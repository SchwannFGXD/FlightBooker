import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {

    Flight flight;
    Passenger passenger;


    @BeforeEach
    public void setUp(){
        flight = new Flight("London", 45678);
        passenger = new Passenger("Zsolt",478388793, 37890);
    }

    @Test
    public void addToList(){
        int expected1 = 0;
        int actual1= flight.getPassengerList().size();
        assertEquals(expected1,actual1);
        flight.addPassenger(passenger);
        int expected2 = 1;
        int actual2= flight.getPassengerList().size();
        assertEquals(expected2,actual2);
    }

    @Test
    public void removeFromList(){
        flight.addPassenger(passenger);
        int expected1 = 1;
        int actual1= flight.getPassengerList().size();
        assertEquals(expected1,actual1);
        flight.removePassenger(passenger);
        int expected2 = 0;
        int actual2= flight.getPassengerList().size();
        assertEquals(expected2,actual2);

    }




}
