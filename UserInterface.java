import java.util.Scanner;
public class UserInterface {
    private final Airline airline;
    private final Scanner scanner;

    // Constructor
    public UserInterface(Airline airline) {
        this.airline = airline;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;

        while (true) {
            System.out.println("\nAirline Reservation System");
            System.out.println("1. View Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Seat");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    cancelSeat();
                    break;
                case 4:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private void displaySeats() {
        System.out.println("\nSeat Availability:");
        airline.displayAvailableSeats();
    }

    private void bookSeat() {
        if (airline.isFullyBooked()) {
            System.out.println("Sorry, the flight is fully booked.");
            return;
        }

        System.out.print("Enter seat number to book (1-" + airline.getTotalSeats() + "): ");
        int seatNumber = scanner.nextInt();
        airline.bookSeat(seatNumber);
    }

    private void cancelSeat() {
        if (airline.isFullyOpen()) {
            System.out.println("No seats have been booked yet.");
            return;
        }

        System.out.print("Enter seat number to cancel (1-" + airline.getTotalSeats() + "): ");
        int seatNumber = scanner.nextInt();
        airline.cancelSeat(seatNumber);
    }
}
