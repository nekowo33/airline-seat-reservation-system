public class Airline {
    private final int TOTAL_SEATS;
    private final boolean[] seats;
    private int bookedSeats = 0;

    // Constructor
    public Airline(int totalSeats) {
        this.TOTAL_SEATS = totalSeats;
        this.seats = new boolean[TOTAL_SEATS];
    }

    public void bookSeat(int seatNumber) {


        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number! Please choose a number between 1 and " + TOTAL_SEATS + ".");
            return;
        }

        if (seats[seatNumber - 1]) {
            System.out.println("Sorry, this seat is already booked.");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("Seat " + seatNumber + " has been booked successfully.");
            bookedSeats++;
        }
    }

    public void cancelSeat(int seatNumber) {

        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number! Please choose a number between 1 and " + TOTAL_SEATS + ".");
            return;
        }

        if (!seats[seatNumber - 1]) {
            System.out.println("This seat is already available.");
        } else {
            seats[seatNumber - 1] = false;
            System.out.println("Seat " + seatNumber + " has been successfully canceled.");
            bookedSeats--;
        }
    }

    // UTILITY METHODS
    public void displayAvailableSeats() {
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print("Seat " + (i + 1) + ": " + (seats[i] ? "Booked" : "Available") + "\n");
        }
    }

    public boolean isFullyBooked() {
        return bookedSeats == TOTAL_SEATS;
    }

    public boolean isFullyOpen() {
        return bookedSeats == 0;
    }

    public int getTotalSeats() {
        return TOTAL_SEATS;
    }
}
