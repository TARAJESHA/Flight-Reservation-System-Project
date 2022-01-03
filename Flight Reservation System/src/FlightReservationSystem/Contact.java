package FlightReservationSystem;
import java.util.*;
public class Contact {
    private String name;
    String emailID;
    private String mobileNumber;


    public Contact(String name, String mobileNumber, String emailID ) {
        this.name=name;
        this.emailID=emailID;
        this.mobileNumber=mobileNumber;
    }


    public String toString(){
        return "Contact[Name : "+name+", "+"mobileNumber : "+mobileNumber+", "+ "emailID : "+emailID+ "]";
    
}
}
