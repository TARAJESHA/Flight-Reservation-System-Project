package FlightReservationSystem;

public class Passenger {
    private static int idCount;
    private static int ID;
    private String password;
    private Address address;
    private Contact contact ;

    public Passenger(String password, Contact contact, Address address){
        this.contact =contact;
        this.address =address;
        this.password=password;

        ID=idCount;
        idCount++;
    }
    public Address getAddress(){
        return address;
    }
    public   Contact getContact(){
        return contact;

    }
    public void updateContact(){
        this.contact=contact;

    }
    public void updateAddress(){
        this.address=address;

    }

    public String getEmailID(){
        return contact.emailID;

    }
    public String getPassword() {
        return password;
    }

    /*public void setEmailID(String emailID){
        this.emailID=emailID;

    }*/
    public static int getID(){
        return ID;

    }
    public static int getPassengerCount(){
        return idCount;

    }

}
