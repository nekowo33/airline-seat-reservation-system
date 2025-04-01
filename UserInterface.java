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
            System.out.println("Current total seats: " + airline.getTotalSeats() + "\n");
            System.out.println("1. View Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Seat");
            System.out.println("4. Add Seats");
            System.out.println("5. Remove Seats");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
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
                    extendSeats();
                    break;
                case 5:
                    removeSeats();
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private boolean validateInput(String input) {
        for (char ch : input.toCharArray()){
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    // Displays the seats
    private void displaySeats() {
        System.out.println("\nSeat Availability:");
        airline.displayAvailableSeats();
    }

    private void bookSeat() {
        // Tells the user if the flight has been fully booked
        if (airline.isFullyBooked()) {
            System.out.println("Sorry, the flight is fully booked.");
            return;
        }

        System.out.println("\nAvailable Seats:");
        airline.displayFreeSeats();

        System.out.print("Enter seat number to book (1-" + airline.getTotalSeats() + "): ");
        String enter = scanner.next();
        boolean isValid = validateInput(enter);

        if (isValid) {
            int seatNumber = Integer.parseInt(enter);
            airline.bookSeat(seatNumber);
        } else {
            System.out.println("Invalid input! Please enter a valid number.");
        }
    }

    private void cancelSeat() {
        // Tells user if no seats have been booked
        if (airline.isFullyOpen()) {
            System.out.println("No seats have been booked yet.");
            return;
        }

        System.out.println("\nBooked Seats:");
        airline.displayOccupiedSeats();

        System.out.print("Enter seat number to cancel (1-" + airline.getTotalSeats() + "): ");
        String cancel = scanner.next();
        boolean isValid = validateInput(cancel);

        if (isValid) {
            int seatNumber = Integer.parseInt(cancel);
            airline.cancelSeat(seatNumber);
        } else {
            System.out.println("Invalid input! Please enter a valid number.");
        }

    }

    private void extendSeats() {
        // Tells the user if total seats are already at maximum capacity
        if (airline.getTotalSeats() == 50) {
            System.out.println("Cannot add any more seats. (Maximum capacity is 50)");
            return;
        }

        System.out.print("Enter number of seats to add: ");

        // Checks if user input is invalid
        String add = scanner.next();
        boolean isValid = validateInput(add);

        if (isValid) {
            int newSeats = Integer.parseInt(add);

            // Checks if user input exceeds maximum capacity of seats
            if ((airline.getTotalSeats() + newSeats) > 50) {
                System.out.println("Error! Added seats exceed maximum capacity of 50");
                return;
            }
            airline.extendSeats(newSeats);
            System.out.println("Number of current seats have been updated to: " + airline.getTotalSeats());
        } else {
            System.out.println("Invalid input! Please enter a valid number.");
        }
    }

    private void removeSeats() {
        System.out.println("DISCLAIMER: This could remove seats that have been booked!");
        if (airline.getTotalSeats() == 10) {
            System.out.println("Cannot remove any more seats. (Minimum capacity is 10)");
            return;
        }

        System.out.print("Enter number of seats to remove: ");
        String remove = scanner.next();
        boolean isValid = validateInput(remove);

        if (isValid) {
            int newSeats = Integer.parseInt(remove);

            if ((airline.getTotalSeats() - newSeats) < 10) {
                System.out.println("Error! Removed seats exceed maximum capacity of 10");
                return;
            }
            airline.removeSeats(newSeats);
            System.out.println("Number of seats have been updated to: " + airline.getTotalSeats());
        } else {
            System.out.println("Invalid input! Please enter a valid number.");
        }
    }
}
