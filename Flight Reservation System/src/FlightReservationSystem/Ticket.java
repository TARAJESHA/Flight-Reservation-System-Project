package FlightReservationSystem;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Ticket{
	private long PNRNumber;
  protected double price;
	private Flight flight;
	private Passenger passenger;
	protected String status;
	private int seatNumber;

	public abstract void setPrice(double price);

	public Ticket(long PNRNumber, Flight flight, Passenger passenger, int seatNumber) {

		this.PNRNumber = PNRNumber;
		this.flight = flight;
		this.passenger = passenger;
		this.seatNumber = seatNumber;

	}

	public double getPrice() {
		return price;
	}

	public String getStatus() {
		return status;
	}

	public LocalDateTime getDepartureDateTime() {
		return flight.getDepartureDateTime();
	}
/*---------------------------calculating the time between the Departure and arrival---------------------------*/
	public Duration getDurationOfJourney(LocalDateTime time1, LocalDateTime time2) {
		return Duration.between(time1, time2);
	}

	public void printDuration() {
		Duration duration = getDurationOfJourney(flight.getDepartureDateTime(), flight.getArrivalDateTime());
		System.out.println(duration.toMinutes()+" minutes");
	}

	public long getPNRNumber() {
		return PNRNumber;
	}

	public void setStatus(String status) {

		this.status = status;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public FlightReservationSystem.Passenger getPassenger() {
		return passenger;
	}

	public FlightReservationSystem.Flight getFlight() {
		return flight;
	}
}

