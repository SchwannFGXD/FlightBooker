import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookerTest {

    Flight flight;
    Passenger passenger;
    Booker booker;

    @BeforeEach
    public void setUp(){
        flight = new Flight("London", 45678);
        passenger = new Passenger("Zsolt",478388793, 37890);
        booker = new Booker();
    }

    @Test
    public void canAddToFlightList(){
        int expected1 = 0;
        int actual1= booker.getFlightList().size();
        assertEquals(expected1,actual1);
        booker.addNewFlight(flight);
        int expected2 = 1;
        int actual2= booker.getFlightList().size();
        assertEquals(expected2,actual2);
    }

    @Test
    public void canAddNewPassenger(){
        int expected1 = 0;
        int actual1= booker.getPassengerList().size();
        assertEquals(expected1,actual1);
        booker.addNewPassenger(passenger);
        int expected2 = 1;
        int actual2= booker.getPassengerList().size();
        assertEquals(expected2,actual2);
    }

    @Test
    public void canGetFlightbyID(){
        Flight flight1 = flight;
        long expected= flight1.getId();

        Flight flight2= booker.getFlightbyID(45678);
        long actual= 45678;

        assertEquals(expected,actual);
    }

    @Test
    public void canBookFlight(){
        int expected1 = 0;
        int actual1= booker.getFlightList().size();
        assertEquals(expected1,actual1);
        booker.addNewFlight(flight);
        booker.addNewPassenger(passenger);
        booker.bookPassenger(flight, passenger);
        int expected2 = 1;

        Flight actualFlight = booker.getFlightbyID(45678);

        int actual2 = actualFlight.getPassengerList().size();

        assertEquals(expected2,actual2);
    }

    @Test
    public void canCancelFlight(){
        booker.addNewFlight(flight);
        booker.addNewPassenger(passenger);
        booker.bookPassenger(flight, passenger);
        int expected1 = 1;
        Flight actualFlight1 =booker.getFlightbyID(45678);
        int actual1 = actualFlight1.getPassengerList().size();
        assertEquals(expected1,actual1);

        booker.cancelFlight(flight, passenger);
        int expected2 = 0;
        Flight actualFlight2 =booker.getFlightbyID(45678);
        int actual2 = actualFlight2.getPassengerList().size();
        assertEquals(expected2,actual2);

    }




}
