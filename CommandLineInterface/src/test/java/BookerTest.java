import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookerTest {

    Flight flight;
    Booker booker;

    @BeforeEach
    public void setUp(){
        flight = new Flight("London");
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
        booker.addNewPassenger("Zsolt",871381762);
        int expected2 = 1;
        int actual2= booker.getPassengerList().size();
        assertEquals(expected2,actual2);
    }

    @Test
    public void canGetFlightbyID(){
        try {
            Flight flight1 = flight;
            int expected = flight1.getId();

            booker.addNewFlight(flight1);

            Flight flight2 = booker.getFlightbyID(expected);
            int actual = flight2.getId();

            assertEquals(expected, actual);
        } catch(Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    @Test
    public void canGetPassengerbyDetail(){
        try {
            booker.addNewPassenger("Zsolt",871381762);
            String expectedName = "Zsolt";
            String actualName = booker.getPassengerByDetails("Zsolt", 871381762).getName();
            assertEquals(expectedName,actualName);
        } catch(Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }

    }

    @Test
    public void canBookFlight(){
        try {
            int expectedSize1 = 0;
            int actualSize1 = booker.getFlightList().size();
            assertEquals(expectedSize1, actualSize1);
            booker.addNewFlight(flight);
            booker.addNewPassenger("Zsolt", 871381762);
            booker.bookPassenger(flight, booker.getPassengerByDetails("Zsolt", 871381762));
            int expectedSize2 = 1;

            int actualId = flight.getId();
            Flight actualFlight = booker.getFlightbyID(actualId);

            int actualSize2 = actualFlight.getPassengerList().size();

            assertEquals(expectedSize2, actualSize2);
        } catch(Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    @Test
    public void canCancelFlight(){
        try{
            booker.addNewFlight(flight);
            booker.addNewPassenger("Zsolt",871381762);
            booker.bookPassenger(flight, booker.getPassengerByDetails("Zsolt",871381762));
            int expectedSize1 = 1;

            int actualId = flight.getId();
            Flight actualFlight1 =booker.getFlightbyID(actualId);
            int actualSize1 = actualFlight1.getPassengerList().size();
            assertEquals(expectedSize1,actualSize1);


            //Flight flight2 = new Flight("London");
            //booker.addNewPassenger("Zolt2",971381762);
            //booker.bookPassenger(flight, booker.getPassengerByDetails("Zolt",971381762));
            //booker.cancelFlight(flight, booker.getPassengerByDetails("Zolt2",971381762));

            booker.cancelFlight(flight, booker.getPassengerByDetails("Zsolt",871381762));
            int expectedSize2 = 0;
            Flight actualFlight2 =booker.getFlightbyID(actualId);
            int actualSize2 = actualFlight2.getPassengerList().size();
            assertEquals(expectedSize2,actualSize2);
        } catch(Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }

    }

    @Test
    public void canGetFlightbyName(){
        try {
            Flight flight1 = flight;
            Flight flight2 = new Flight("London");
            Flight flight3 = new Flight("Manchester");
            booker.addNewFlight(flight1);
            booker.addNewFlight(flight2);
            booker.addNewFlight(flight3);

            List<Flight> flightListToLondon = booker.getFlightbyName("London");

            int expectedSize = 2;

            int actualSize = flightListToLondon.size();
            assertEquals(expectedSize, actualSize);

            String expectedDestination = "London";

            String actualDestination0 = flightListToLondon.get(0).getDestination();
            String actualDestination1 = flightListToLondon.get(1).getDestination();

            assertEquals(expectedDestination, actualDestination0);
            assertEquals(expectedDestination, actualDestination0);
        } catch(Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

}
