package FlightReservationSystem;
import java.util.*;
public class TouristTicket {
  public long price;
  public int seatNo, PNR;
  public List<String> TouristLocations;

  public TouristTicket(int PNR, int seatNo, long price, List<String> TouristLocations){
    this.PNR=PNR;
    this.price=price;
    this.seatNo=seatNo;
    this.TouristLocations=TouristLocations;

  }
  public List<String> getTouristLocations(){
    return TouristLocations;
  }
  public void addTouristLocations(String TouristLocation ){
    TouristLocations.add(TouristLocation);
    }


  public void deleteTouristLocations(String TouristLocation) {
    TouristLocations.remove(TouristLocation);
  }



}
