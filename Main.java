public class Main {
    public static void main(String[] args) {
        Airline japan = new Airline(10);
        UserInterface ui = new UserInterface(japan);
        ui.start();
    }
}
