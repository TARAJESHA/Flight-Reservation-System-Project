package FlightReservationSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.time.*;
public class Main {
  public static void main(String args[]) {
    /* --------------------First Passenger Address details--------------------------------------*/
    Address firstPassengerAddress=new Address("India","Karnataka","Bengalore","Avalahalli", "maruthi Smart City");
    System.out.println("Address:- Street  :  "+firstPassengerAddress.street + ",    Village  :  "+firstPassengerAddress.village + ",    City  :  "+firstPassengerAddress.city + ",    State  :  "+firstPassengerAddress.state +",    Country  :  "+ firstPassengerAddress.county);
    System.out.println(" ");
    /* --------------------First Passenger Contact details--------------------------------------*/
    Contact firstPassenContact =new Contact("Rajesh","raj@gmail.com", 9964);
    System.out.println("Name  :  "+firstPassenContact.name+",    Email   :  " + firstPassenContact.email+ ",    Mobile Number   :   " + firstPassenContact.email);
    System.out.println(" ");


    Passenger passenger=new Passenger("Rajesh", "ABCDEF");
    System.out.println("Passenger Name  :  "+ passenger.userName +",  Passenger ID  :  " + passenger.id);
    System.out.println(" ");
/* --------------------Check the Flight Departure & Arrivel --------------------------------------*/
    LocalDateTime flightdepartureDateTime= LocalDateTime.of(2020 , 1, 2, 10, 30);
    LocalDateTime flightArrivelDateTime= LocalDateTime.of(2020 , 1, 2, 10, 30);

    Flight avalableFlight=new Flight("Indigo", "Bengalore", "Goa", flightdepartureDateTime, flightArrivelDateTime,  40 , 20);
    System.out.println("Flight Name   :  " +avalableFlight.flightName + ",   Flight Departure Location  :  " + avalableFlight.fligthDepatureLocation + ",   Flight Departure Time & Date  :  " + avalableFlight.fligthDepatureDateTime );
    System.out.println(" ");
    System.out.println("Flight Arrival Location  :  " + avalableFlight.fligthArrivalLocation + ",   Flight Arrival Date & Time   :  " + avalableFlight.fligthDepatureDateTime + ",   No of Seats  :  "+ avalableFlight.noOfseats + ",   No of Seats Booked  :  "+ avalableFlight.noOfseatBooked);
    System.out.println(" ");
  
    System.out.println("The Current Capacity of the Flight "+avalableFlight.flightName+ "   :  "+avalableFlight.getFlightCapacity());

/* --------------------Passenger Choose the Ticket Type--------------------------------------*/
    System.out.println(" ");
    System.out.print("If your choosing Regular Ticket Please enter 1 or If your choosing Tourist Ticket Please enter 2 :  ");
    System.out.println(" ");

    Scanner sc =new Scanner(System.in);
    int inputTicket = sc.nextInt();
/* --------------------Passenger Chosen Regular Ticket Type--------------------------------------*/
    if(inputTicket == 1){

      List<String> services =new ArrayList<>();
      services.add("food");
      services.add("water");
      services.add("snacks");
      RegularTicket regular=new RegularTicket(3222, 40, 6000, services);
      regular.addService("Coco-cola");
	  	regular.deleteService("food");
      System.out.println("PNR  :  "+ regular.PNR +",  Seat No  :  "+ regular.seatNumber +",   Price   :"+regular.price+",   Special Services  :  "+regular.services);


    }

/* --------------------Passenger Chosen Tourist Ticket Type--------------------------------------*/
    else if(inputTicket ==2){
      List<String> TouristLocations = new ArrayList<>();
      TouristLocations.add("Goa");
      TouristLocations.add("Taj Mahal");
      TouristLocations.add("Golden City");
      TouristLocations.add("Red Fort");
      TouristLocations.add("Mehrangarh Fort");


      TouristTicket Tourist=new TouristTicket (3225, 40, 20000, TouristLocations);
      Tourist.deleteTouristLocations("Red Fort");
      Tourist.addTouristLocations("Mysore Palace");
      /* If we add more than 5 L0cation I will Stop Process*/

       // Tourist.addTouristLocations("Mysore Palace");
      int size=TouristLocations.size();
      /* Checking the location is not more than 5 Locations*/
      if(size <=5){
         System.out.println("PNR  :  "+ Tourist.PNR +"  SeatNo  :  "+ Tourist.seatNo +"   Price   :"+Tourist.price+"   Tourist Locations  :  "+Tourist.TouristLocations);
       }

      else{
         System.out.println("Your addede more then 5 Location Please try it again ");
      }
    }
/* --------------------If Passenger Chosen other than 1&2 it will show Input is Wrong--------------------------------------*/
    else{
      System.out.println("Input is Wrong retry it");
    }
  }

}
