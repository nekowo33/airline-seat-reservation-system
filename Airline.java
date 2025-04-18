public class Airline {
    private int TOTAL_SEATS;
    private boolean[] seats;
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

    public void extendSeats(int numberOfSeats) {
        this.TOTAL_SEATS += numberOfSeats;
        boolean[] newSeats = new boolean[TOTAL_SEATS];

        for (int i = 0; i < seats.length; i++) {
            newSeats[i] = seats[i];
        }

        this.seats = newSeats;
    }

    public void removeSeats(int numberOfSeats) {
        this.TOTAL_SEATS -= numberOfSeats;
        boolean[] newSeats = new boolean[TOTAL_SEATS];

        for (int i = 0; i < newSeats.length; i++) {
            newSeats[i] = seats[i];
        }

        this.seats = newSeats;
    }

    // UTILITY METHODS
    public void displayAvailableSeats() {
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print("Seat " + (i + 1) + ": " + (seats[i] ? "Booked" : "Available") + "\n");
        }
    }

    public void displayFreeSeats() {
        for (int i = 0; i < TOTAL_SEATS; i++) {
            if (!seats[i]) {
                System.out.print("Seat " + (i + 1) + ": " + "Available" + "\n");
            } else {
                System.out.print("");
            }
        }
    }

    public void displayOccupiedSeats() {
        for (int i = 0; i < TOTAL_SEATS; i++) {
            if (seats[i]) {
                System.out.print("Seat " + (i + 1) + ": " + "Booked" + "\n");
            } else {
                System.out.print("");
            }
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

    public int getTotalSeats() {
        return TOTAL_SEATS;
    }
}
