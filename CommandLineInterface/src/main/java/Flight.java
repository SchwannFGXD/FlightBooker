import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String destination;
    private long id;
    private List<Passenger> passengerList;
    public Flight(String destination, long id){
        this.destination=destination;
        this.id=id;
        this.passengerList= new ArrayList<>();
    }

    //methods

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }



    public void removePassenger(Passenger passenger){
        passengerList.remove(passenger);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
