import javax.print.attribute.standard.NumberOfDocuments;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {


        boolean running = true;
        Booker booker = new Booker();
        Flight flight2 = new Flight("LONDON");
        booker.addNewFlight(flight2);
        booker.addNewFlight("lONDON");
        booker.addNewFlight("MANCHESTER");
        booker.addNewFlight("EDINBURGH");
        booker.addNewFlight("CARDIFF");

        while (running){
            Scanner scanner = new Scanner(System.in);
            Scanner scannerYN = new Scanner(System.in);

            //where do u want to go>?
            System.out.println("Where would you like to book a flight to?");
            // get input
            String answer = scanner.nextLine();
            List<Flight> flightListToDestination = booker.getFlightbyName(answer.toUpperCase());

            if(flightListToDestination.isEmpty()){
                System.out.println("Sorry, no flight available to that destination.");
                //if destination doesn't exist ask them for different destination
                System.out.println("Would you like to choose another destination? yes/no");
                String answerAnotherDest = scannerYN.nextLine();
                if(answerAnotherDest.toUpperCase().equals("NO")){
                    System.exit(0);
                }
                if (answerAnotherDest.toUpperCase().equals("YES")){
                }
            }

            else {
                running =false;
            }

        }

        System.out.println("There are flights to ");
        //next part
        //question do you want to book a flight to "destination"
        //yes or no
        //if yes bookpassenger
        //if no do you want to choose another destination
        //if book passenger ask if they want to cancel flight
    }
}


