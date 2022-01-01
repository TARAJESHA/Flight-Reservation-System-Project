package FlightReservationSystem;

import java.util.List;

public class RegularTicket  {
	public int seatNumber;
	public long price, PNR;
	public List<String> services;


	public RegularTicket(long PNR, int seatNumber, long price, List<String> services){
		this.PNR=PNR;
		this.seatNumber=seatNumber;
		this.price=price;
		this.services=services;

	}

public List<String> getServices() {
	return services;
}



public void addService(String service) {
	services.add(service);
}

public void deleteService(String service) {
	services.remove(service);
}

}
