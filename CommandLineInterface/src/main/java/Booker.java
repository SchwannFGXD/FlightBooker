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

    //adds flight to list of flights
    public void addNewFlight(Flight flight){
        flightList.add(flight);
    }

    //create a flight & add that flight to list of passengers
    public void addNewFlight(String destination){
        Flight flight = new Flight(destination);
        flightList.add(flight);
    }

    //create a passenger & add that passenger to list of passengers
    public void addNewPassenger(String name, long contactInfo){
        Passenger passenger = new Passenger(name,contactInfo);
        passengerList.add(passenger);
    }

    //returns passenger by details
    public Passenger getPassengerByDetails(String name, long contactInfo) throws Exception{
        //loops through passengerlist and returns if they are matching
        for (Passenger passenger: passengerList) {
            if (passenger.getName() == name && passenger.getContactInfo()==contactInfo) {
                return passenger;
            }
        }
        //if wrong passenger/they dont exist
        throw new Exception("Wrong combination of passenger details");
    }
    //return flight based on specific id
    public Flight getFlightbyID(int id) throws Exception{
        for (Flight flight: flightList) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        //if flight id doesn't exist
        throw new Exception("Flight doesn't exist");
    }

    //return flight based on specific name
    public List<Flight> getFlightbyName(String name){
        List<Flight> flightSameDestination = new ArrayList<>();
        for (Flight flight: flightList) {
            if (flight.getDestination() == name) {
                flightSameDestination.add(flight);
            }
        }
        return flightSameDestination;
    }



    public void bookPassenger(Flight flight, Passenger passenger){
        flight.addPassenger(passenger);
    }

    public void cancelFlight(Flight flight, Passenger passenger) throws Exception{
        String actualName= passenger.getName();
        long actualContactInfo= passenger.getContactInfo();
        //if flight exists, no problem. if flight doesn't exist, throws exception
        if(getFlightbyID(flight.getId())== flight){
            //if passenger booked flight previously, no problem, if passenger no booked for flight, throws exception
            if(flight.getPassenger(actualName,actualContactInfo)==passenger){
                flight.removePassenger(passenger);
            }
        }
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

