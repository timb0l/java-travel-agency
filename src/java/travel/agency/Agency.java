package java.travel.agency;

import java.time.LocalDate;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--- WELCOME TO JAVA TRAVEL AGENCY ---");

        boolean travel = true;
        while (travel) {
            try {
                System.out.println("Wanna go on a holiday? Y/N: ");
                String yn = scan.nextLine();

                if (yn.equalsIgnoreCase("n")) {
                    travel = false;
                } else if (yn.equalsIgnoreCase("y")) {
                    System.out.print("Insert Destination: ");
                    String destination = scan.nextLine();

                    System.out.print("Date departure (yyyy-MM-dd)");
                    String departureDate = scan.nextLine();
                    LocalDate departure = LocalDate.parse(departureDate);

                    System.out.print("Date Arrival (yyyy-MM-dd)");
                    String arrivalDate = scan.nextLine();
                    LocalDate arrival = LocalDate.parse(arrivalDate);

                    Holiday vacay = new Holiday(destination, departure, arrival);
                    System.out.println("Holiday confirmed to " + vacay.getDestination() + " for " + vacay.estimate() + " days from " + vacay.getDeparture() + " to " + vacay.getArrival());
                } else {
                    System.out.println("Try again.");
                }
            } catch (RuntimeException i){
                System.out.println("Error: " + i.getMessage());
            }
        }
        scan.close();
    }
}

