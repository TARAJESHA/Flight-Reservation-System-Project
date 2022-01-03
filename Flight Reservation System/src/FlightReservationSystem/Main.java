package FlightReservationSystem;

import java.util.*;
import java.time.LocalDateTime;
public class Main {
    public static void main(String args[]) {

        boolean isValidated = false;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        Passenger p = null;

        addFlights();
        addPassengerTickets();

        while (!isValidated || option > 3) {
            System.out.println("");
            System.out.println("Welcome to the flight reservation system ");
            System.out.println("");
            System.out.println("Sign-In ---------------------------- ->Please Enter 1  :");
            System.out.println("");
            System.out.println("Create a new registration------------->Please Enter 2  :");
            System.out.println("");
            option = sc.nextInt();


            /*---------------------------------------------- Sing-In----------------------------------------*/
            switch (option) {
                case 1: {
                    System.out.println("Email ID  : ");
                    String emailID = sc.next();
                    // String mobileNumber = userDate;
                    System.out.println("Enter Password");
                    String password = sc.next();
                    //  if (mobileNumber.length() == 10 && mobileNumber.charAt(0) <= 9) {
                    //  isValidated = Permission.validateUser(mobileNumber, password);

                    // } else {
                    isValidated = Permission.validateUser(emailID, password);
                    // }
                    if (isValidated) {
                        System.out.println("");
                        System.out.println("Successfully Sign-In");
                        System.out.println("");
                    }

                    break;
                }
                /*---------------------------- Create a new Account-------------------------*/
                case 2: {
                    System.out.println("Enter Passenger Details  : ");
                    System.out.println("Enter Passenger Name");
                    String name = sc.next();
                    System.out.println("Passenger Password");
                    String password = sc.next();
                    System.out.println("");
                    System.out.println("Passenger Mobile Number");
                    String mobileNumber = sc.next();
                    System.out.println("");
                    System.out.println("Passenger Email ID");
                    String emailID = sc.next();
                    System.out.println("");
                    boolean EmailStatus = Permission.emailIDExists(emailID);
                    if (EmailStatus) {
                        System.out.println("Email ID already Exists ");
                        System.out.println("");
                        break;
                    }
                    System.out.println("Enter Address Details  : ");
                    System.out.println("");
                    System.out.println("Street  :  ");
                    String street = sc.next();
                    System.out.println("");
                    System.out.println("Village  :  ");
                    String village = sc.next();
                    System.out.println("");
                    System.out.println("City     :  ");
                    String city = sc.next();
                    System.out.println("");
                    System.out.println("State    :  ");
                    String state = sc.next();
                    System.out.println("");
                    System.out.println("Country  :  ");
                    String country = sc.next();
                    System.out.println("");
                    Address address = new Address(street, village, city, state, country);
                    Contact contact =new Contact(name, mobileNumber, emailID);
                    p = new Passenger(password,contact, address);
                    Permission.registerPassenger(p);
                    System.out.println("...............Registration Successful Please Sing-In................ ");
                    break;

                }
            }
        }

            while (true) {
                System.out.println("Exit--------------------------------> Please enter 0 : ");
                System.out.println("Available Flight Details------------> Please enter 1 : ");
                System.out.println("Book the Flights--------------------> Please enter 2 : ");
                System.out.println("Show the tickets Details------------> Please enter 3 : ");
                System.out.println("View the Passenger Details----------> Please enter 4 : ");
                System.out.println("Update Passenger Contact Details----> Please enter 5 : ");
                System.out.println("Update Passenger Address Details----> Please enter 6 : ");

                System.out.println("");

                int option1 = sc.nextInt();

                switch (option1) {
                    case 0: {
                        System.exit(0);
                        break;
                    }
                    case 1: {
                        Permission.printAvailableFlights();
                        break;
                    }
                    case 2: {
                        Permission.printAvailableFlights();
                        System.out.println("Enter your Flight serial Number : ");
                        int index = sc.nextInt();

                        System.out.println("Please Choose your Ticket Type  :  ");
                        System.out.println("Regular Ticket------>Please Enter  1 : ");
                        System.out.println("Tourist Ticket------>Please Enter  2 : ");
                        int ticketType1 = sc.nextInt();
                        String ticketType;
                        if(ticketType1==1){ticketType="RegularTicket";}
                        else{ticketType="TouristTicket";}


                        Permission.bookSeat(index, p, ticketType);
                        break;
                    }
                    case 3: {
                        List<Ticket> tickets = Permission.getAllTickets(p);
                        if (tickets != null) {
                            for (Ticket ticket : tickets) {
                                if (!ticket.getStatus().equals("Cancelled"))
                                    System.out.println("PNR Number: " + ticket.getPNRNumber());
                            }
                        } else {
                            System.out.println("No Tickets Found");
                            System.out.println("Please Book the Ticket Again");

                        }

                        System.out.println();
                        System.out.println("Return Back------------------------------------>Please Enter 0 : ");
                        System.out.println("Ticket Details--------------------------------->Please Enter 1 : ");
                        System.out.println("Duration of Journey---------------------------->Please Enter 2 : ");
                        System.out.println("Special Services for the Passenger------------->Please Enter 3 : ");
                        System.out.println("Update Special Services for the Passenger------>Please Enter 4 : ");
                        System.out.println("Update Tourist Locations----------------------->Please Enter 5 : ");
                        System.out.println("Cancel a Ticket-------------------------------->Please Enter 6 : ");
                        System.out.println("Check Status of Ticket------------------------->Please Enter 7 : ");

                        int option2 = 0;
                        long PNRNumber = 0;
                        option2 = sc.nextInt();
                        switch (option) {
                            case 0: {
                                System.exit(0);
                                break;
                            }
                            case 1: {
                                System.out.println("Please Enter Your Ticket(PNR) Number");
                                PNRNumber = sc.nextLong();
                                Permission.printTicketDetails(p, PNRNumber);
                                break;
                            }
                            case 2: {
                                System.out.println("Please Enter Your Ticket(PNR) Number");
                                PNRNumber = sc.nextLong();
                                Permission.printDuration(PNRNumber, p);
                                break;
                            }
                            case 3: {
                                System.out.println("Please Enter Your Ticket(PNR) Number");
                                PNRNumber = sc.nextLong();
                                Permission.printServices(PNRNumber, p);
                                break;
                            }
                            case 4: {
                                System.out.println("Please Enter Your Ticket(PNR) Number");
                                PNRNumber = sc.nextLong();
                                System.out.println("Do u want to");
                                System.out.println("add a Service------>Please Enter  1 :");
                                System.out.println("update a Service--->Please Enter  2 :");
                                System.out.println("remove Service----->Please Enter  3 :");
                                int op2 = sc.nextInt();
                                Permission.updateServices(op2, PNRNumber, p);
                                break;
                            }
                            case 5: {
                                System.out.println("Please Enter Your Ticket(PNR) Number");
                                PNRNumber = sc.nextLong();
                                System.out.println("add a Tourist Location------>Please Enter  1 :");
                                System.out.println("remove Tourist Location----->Please Enter  2 :");
                                int op2 = sc.nextInt();
                                Permission.updateTouristLocation(op2, PNRNumber, p);
                                break;
                            }
                            case 6: {
                                System.out.println("Please Enter Your Ticket(PNR) Number");
                                PNRNumber = sc.nextLong();
                                System.out.println("Do u want to Cancel the Regular Ticket----->Please Enter 1 : ");
                                System.out.println("Do u want to Cancel the Tourist Ticket----->Please Enter 2 : ");
                                int op2 = sc.nextInt();
                                Boolean ticketType = Permission.CancelTicket(PNRNumber, p);
                                if (ticketType) {
                                    System.out.println("Ticket(PNR) Number : " + PNRNumber + " is Successfully Cancelld");
                                } else {
                                    System.out.println("Ticket(PNR) Number" + PNRNumber + "it Couldn't Cancelled, either you are Wrong PNR Number");
                                }

                                break;
                            }
                            case 7: {
                                System.out.println("Please Enter Your Ticket(PNR) Number");
                                PNRNumber = sc.nextLong();
                                Permission.checkStatus(PNRNumber, p);
                                break;
                            }


                        }
                        break;
                    }

                    case 4: {
                        Permission.printPassengerDetails(p);
                        break;
                    }
                    case 5: {
                        System.out.println("Update Passenger Details  : ");
                        System.out.println("Passenger Name");
                        System.out.println("");
                        String name = sc.next();
                        System.out.println("");
                        System.out.println("Passenger Mobile Number");
                        String mobileNumber = sc.next();
                        System.out.println("");
                        System.out.println("Passenger Email ID");
                        String emailID = sc.next();
                        System.out.println("");
                        p.updateContact();
                        break;
                    }
                    case 6: {
                        System.out.println("Update the Address Details  : ");
                        System.out.println("");
                        System.out.println("Street  :  ");
                        String street = sc.next();
                        System.out.println("");
                        System.out.println("Village  :  ");
                        String village = sc.next();
                        System.out.println("");
                        System.out.println("City     :  ");
                        String city = sc.next();
                        System.out.println("");
                        System.out.println("State    :  ");
                        String state = sc.next();
                        System.out.println("");
                        System.out.println("Country  :  ");
                        String country = sc.next();
                        System.out.println("");
                        p.updateAddress();
                        break;

                    }
                }
            }
        }

    public static void addFlights() {
/*--------------------------Flight List--------------------------------------/*
      /*-------------------Flight 1-------------------------------------*/
        LocalDateTime flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        LocalDateTime flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight1 = new Flight("1280","Indigo", "Bengalore", "Goa", flightdepartureDateTime, flightArrivelDateTime, 40, 20, 11000);

        /*-------------------Flight 2-------------------------------------*/
        flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight2 = new Flight("1290" ,"Air India", "Bengalore", "Mumbai", flightdepartureDateTime, flightArrivelDateTime, 40, 25,14000);

        /*-------------------Flight 3-------------------------------------*/
        flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight3 = new Flight("1590" ,"AirAsia India", "Bengalore", "Chennai", flightdepartureDateTime, flightArrivelDateTime, 40, 30,10000);

        /*-------------------Flight 4-------------------------------------*/
        LocalDateTime flightDepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight4 = new Flight("1520" ,"Vistara", "Bengalore", "Lucknow", flightdepartureDateTime, flightArrivelDateTime, 40, 22, 9000);

        /*-------------------Flight 5-------------------------------------*/
        flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight5 = new Flight("6290" ,"AirAsia India", "Bengalore", "Surat", flightdepartureDateTime, flightArrivelDateTime, 40, 16, 10000);

        /*-------------------Flight 6-------------------------------------*/
        flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight6 = new Flight("1000" ,"Vistara", "Bengalore", "Indore", flightdepartureDateTime, flightArrivelDateTime, 40, 18, 6000);

        /*-------------------Flight 7-------------------------------------*/
        flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight7 = new Flight("2121" ,"AirAsia India", "Bengalore", "Delhi", flightdepartureDateTime, flightArrivelDateTime, 40, 26, 12000);

        /*-------------------Flight 8-------------------------------------*/
        flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight8 = new Flight("3999" ,"Air India", "Bengalore", "Bhubaneswar", flightdepartureDateTime, flightArrivelDateTime, 40, 8, 17000);

        /*-------------------Flight 9-------------------------------------*/
        flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight9 = new Flight("8900" ,"Indigo", "Bengalore", "Hyderabad", flightdepartureDateTime, flightArrivelDateTime, 40, 36, 18000);

        /*-------------------Flight 10-------------------------------------*/
        flightdepartureDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        flightArrivelDateTime = LocalDateTime.of(2020, 1, 2, 10, 30);
        Flight flight10 = new Flight("9990" ,"Vistara", "Bengalore", "Mangalor", flightdepartureDateTime, flightArrivelDateTime, 40, 27, 15000);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);
        flights.add(flight6);
        flights.add(flight7);
        flights.add(flight8);
        flights.add(flight9);
        flights.add(flight10);
        Permission.addFlights(flights);


    }

    public static void addPassengerTickets() {

        Map<Passenger, List<Ticket>> map = new HashMap<>();
        List<Ticket> ticketList1 = new ArrayList<>();
        Address passengerAddress = new Address("India","Karnataka","Bangalore","Bidare Agrahara","Maruthi Smart City");
        Contact passengerContact = new Contact("Raj", "1234567890",  "rajeshata2019@gmail.com");
        Passenger passenger1 = new Passenger("1111",passengerContact, passengerAddress);

        Address hotelAddress1 = new Address("India", "Goa", "vasco da Gama", "Baina", "Cross 5" );

        RegularTicket ticket1 = new RegularTicket(201, Permission.getAvailableFlights().get(0), passenger1, 6, 20500, Arrays.asList("service1", "service2"));

        TouristTicket ticket2 = new TouristTicket(122, Permission.getAvailableFlights().get(1), passenger1, 9,10000, hotelAddress1, Arrays.asList("loc1", "loc2"));



        ticketList1.add( ticket1);
        ticketList1.add(ticket2);
        map.put(passenger1, ticketList1);

        ////initializing Passenger- ticket 2
        List<Ticket> ticketList2 = new ArrayList<>();
        Address address2 = new Address("indian", "telangana", "Hyderabad", "manikonda","cross3");
        Contact contact2 =new Contact("Rajesh", "1234567892", "raja@gmail.com");
        Passenger passenger2 = new Passenger("1111111111",contact2, address2);
        TouristTicket ticket3 = new TouristTicket(15, Permission.getAvailableFlights().get(1), passenger1, 2,
                1000, hotelAddress1, Arrays.asList("loc5", "loc2"));
        RegularTicket ticket4 = new RegularTicket(16, Permission.getAvailableFlights().get(0), passenger1, 2,
                20000, Arrays.asList("service3", "service2"));
        ticketList2.add(ticket3);
        ticketList2.add(ticket4);
        map.put(passenger2, ticketList2);
        Permission.addPassengerTicket(map);
    }
}










