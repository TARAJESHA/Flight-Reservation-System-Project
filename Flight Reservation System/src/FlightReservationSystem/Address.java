package FlightReservationSystem;
import java.util.*;
public class Address {
	private String county, state, city, village, street;
	
	public Address(  String street,String village,String city,String state, String country ){
		this.street=street;
		this.village=village;
		this.city=city;
		this.state=state;
		this.county=country;

	}
	@Override
	public String toString() {
			return "Address[street : "+street + ",village : "+village+", city :" + city +", state : " + state + ", county : "+county +"]";
	}
		}
