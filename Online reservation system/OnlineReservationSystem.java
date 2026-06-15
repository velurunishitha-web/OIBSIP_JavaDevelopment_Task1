import java.util.Random;
import java.util.Scanner;

public class OnlineReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Login Details
        String loginId = "admin";
        String password = "1234";
        // Reservation Variables
        String passengerName = "";
        int age = 0;
        int trainNumber = 0;
        String trainName = "";
        String classType = "";
        String journeyDate = "";
        String fromPlace = "";
        String destination = "";

        // Generate Random PNR
        Random random = new Random();
        int pnrNumber = random.nextInt(900000) + 100000;

        System.out.println("===== ONLINE RESERVATION SYSTEM =====");

        // Login
        System.out.print("Enter Login ID: ");
        String enteredId = sc.nextLine();

        System.out.print("Enter Password: ");
        String enteredPassword = sc.nextLine();

        // Check Login
        if (enteredId.equals(loginId)
                && enteredPassword.equals(password)) {

            System.out.println("Login Successful!");

            int choice;

            do {
                System.out.println("\n===== MAIN MENU =====");
                System.out.println("1. Reservation Form");
                System.out.println("2. Cancellation Form");
                System.out.println("3. Logout");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // Reservation Form
                    case 1:

                        System.out.println("\n===== RESERVATION FORM =====");

                        System.out.print("Enter Passenger Name: ");
                        passengerName = sc.nextLine();

                        System.out.print("Enter Age: ");
                        age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Train Number: ");
                        trainNumber = sc.nextInt();
                        sc.nextLine();

                        // Train Name Auto Display
                        if (trainNumber == 12345) {
                            trainName = "Rajdhani Express";
                        } 
                        else if (trainNumber == 54321) {
                            trainName = "Shatabdi Express";
                        } 
                        else {
                            trainName = "Unknown Train";
                        }

                        System.out.println("Train Name: " + trainName);

                        System.out.print("Enter Class Type (Sleeper/AC): ");
                        classType = sc.nextLine();

                        System.out.print("Enter Journey Date: ");
                        journeyDate = sc.nextLine();

                        System.out.print("From Place: ");
                        fromPlace = sc.nextLine();

                        System.out.print("Destination: ");
                        destination = sc.nextLine();

                        System.out.println("\n===== TICKET BOOKED SUCCESSFULLY =====");
                        System.out.println("PNR Number: " + pnrNumber);
                        System.out.println("Passenger Name: " + passengerName);
                        System.out.println("Train Number: " + trainNumber);
                        System.out.println("Train Name: " + trainName);
                        System.out.println("Class Type: " + classType);
                        System.out.println("Journey Date: " + journeyDate);
                        System.out.println("From: " + fromPlace);
                        System.out.println("To: " + destination);

                        break;

                    // Cancellation Form
                    case 2:

                        System.out.println("\n===== CANCELLATION FORM =====");

                        System.out.print("Enter PNR Number: ");
                        int enteredPNR = sc.nextInt();

                        if (enteredPNR == pnrNumber) {

                            System.out.println("\nTicket Details:");
                            System.out.println("Passenger Name: " + passengerName);
                            System.out.println("Train Name: " + trainName);
                            System.out.println("Journey Date: " + journeyDate);

                            System.out.print("Confirm Cancellation? (yes/no): ");
                            sc.nextLine();
                            String confirm = sc.nextLine();

                            if (confirm.equalsIgnoreCase("yes")) {
                                System.out.println("Ticket Cancelled Successfully!");
                            } else {
                                System.out.println("Cancellation Cancelled!");
                            }

                        } else {
                            System.out.println("Invalid PNR Number!");
                        }

                        break;

                    // Logout
                    case 3:
                        System.out.println("Logged Out Successfully!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 3);

        } else {
            System.out.println("Invalid Login ID or Password!");
        }

        sc.close();
    }
}