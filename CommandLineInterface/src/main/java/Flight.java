import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String destination;
    private int id;
    private List<Passenger> passengerList;
    public Flight(String destination){
        //min and max for random id
        int min =10000;
        int max =99999;
        //random id
        int random = (int) Math.floor(Math.random()*(max-min+1)+min);

        this.destination=destination;
        this.id=random;
        this.passengerList= new ArrayList<>();
    }

    //methods

    //add passenger to list of passengers
    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }


    //remove passenger from list of passengers
    public void removePassenger(Passenger passenger){
        passengerList.remove(passenger);
    }

    public Passenger getPassenger(String name, long contactInfo) throws Exception{
        for (Passenger passenger: passengerList) {
            if (passenger.getName() == name && passenger.getContactInfo()==contactInfo) {
                return passenger;
            }
        }
        //if passenger doesn't exist
        throw new Exception("Passenger doesn't exist");

    }


    //getters and setters

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }
}
