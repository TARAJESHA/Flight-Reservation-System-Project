package FlightReservationSystem;


public class Passenger {
    public int passengerID, id;
    public String userName, passWord;
    public Passenger(String userName, String passWord){
        this.userName=userName;
        this.passWord=passWord;
        passengerID++;
        this.id=passengerID;
    }

    }
