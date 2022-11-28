import java.util.ArrayList;
import java.util.List;

public class Booker {
    private List<Passenger> passengerList;
    private List<Flight> flightList;

    public Booker(){
        this.passengerList= new ArrayList<>();
        this.flightList= new ArrayList<>();
    }

    //methods
    public void addNewFlight(Flight flight){
        flightList.add(flight);
    }

    public void addNewPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public Flight getFlightbyID(long id){
        for (Flight flight: flightList) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

    public void bookPassenger(Flight flight, Passenger passenger){
        flight.addPassenger(passenger);
    }

    public void cancelFlight(Flight flight, Passenger passenger){
        flight.removePassenger(passenger);
    }

    //getters setters
    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }
}

