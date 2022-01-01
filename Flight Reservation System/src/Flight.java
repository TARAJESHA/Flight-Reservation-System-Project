package FlightReservationSystem;

import java.time.LocalDateTime;

public class Flight {


  public String flightName, fligthDepatureLocation, fligthArrivalLocation;
  public int noOfseats, noOfseatBooked;
  LocalDateTime fligthDepatureDateTime, fligthArrivalDateTime;

  public Flight(String flightName, String fligthDepatureLocation, String fligthArrivalLocation , LocalDateTime fligthDepatureDateTime, LocalDateTime fligthArrivalDateTime, int noOfseats, int noOfseatBooked){
    this.flightName=flightName;
    this.fligthDepatureLocation=fligthDepatureLocation;
    this.fligthDepatureDateTime=fligthDepatureDateTime;
    this.fligthArrivalLocation=fligthArrivalLocation;
    this.fligthArrivalDateTime=fligthArrivalDateTime;
    this.noOfseats=noOfseats;
    this.noOfseatBooked=noOfseatBooked;

  }

  public int getFlightCapacity(){
    
    return noOfseats - noOfseatBooked;
  }
  


}
