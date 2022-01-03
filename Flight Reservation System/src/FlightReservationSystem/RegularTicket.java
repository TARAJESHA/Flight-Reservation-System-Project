package FlightReservationSystem;

import java.util.List;

public class RegularTicket extends FlightReservationSystem.Ticket {

	public List<String> services;


	public RegularTicket(long PNRNumber, FlightReservationSystem.Flight flight, FlightReservationSystem.Passenger passenger, int seatNumber,double price, List<String> services) {
		super(PNRNumber, flight, passenger, seatNumber);
		setPrice(price);
		setStatus("Cancelled");
		this.services = services;

	}
	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(int index, String service) {
		services.set(index, service);
	}

	public void addService(String service) {
		services.add(service);
	}

	public void deleteService(String service) {
		services.remove(service);
	}
}
