package FlightReservationSystem;

import java.time.LocalDateTime;

public class Flight {


  private String flightName, fligthDepatureLocation, fligthArrivalLocation, flightNumber;
  public int noOfseats, noOfseatBooked, capacity, price;
  LocalDateTime fligthDepatureDateTime, fligthArrivalDateTime;

  public Flight(String flightNumber, String flightName, String fligthDepatureLocation, String fligthArrivalLocation,
                LocalDateTime fligthDepatureDateTime, LocalDateTime fligthArrivalDateTime, int capacity, int noOfseatBooked, int price) {
    this.flightNumber = flightNumber;
    this.flightName = flightName;
    this.fligthDepatureLocation = fligthDepatureLocation;
    this.fligthArrivalLocation = fligthArrivalLocation;
    this.fligthDepatureDateTime = fligthDepatureDateTime;
    this.fligthArrivalDateTime = fligthArrivalDateTime;
    this.price=price;
    this.capacity = capacity;
    this.noOfseatBooked=noOfseatBooked;

  }

  public LocalDateTime getDepartureDateTime() {
    return fligthDepatureDateTime;
  }

  public LocalDateTime getArrivalDateTime() {
    return fligthArrivalDateTime;
  }

  public String getAirlineName() {
    return flightName;
  }

  public void setAirlineName(String flightName) {
    this.flightName = flightName;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  public int getNoOfSeatsBooked() {
    return noOfseatBooked;
  }
  public void setNoOfSeatsBooked(int noOfSeatsBooked) {
    this.noOfseatBooked = noOfseatBooked;
  }

  public int getCurrentCapacity() {
    return capacity - noOfseatBooked;
  }

  public String getDepartureLocation() {
    return fligthDepatureLocation;
  }

  public String getDestinationLocation() {
    return fligthArrivalLocation;
  }
}
