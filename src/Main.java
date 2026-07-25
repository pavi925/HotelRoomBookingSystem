import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelManager manager = new HotelManager();

        int choice;

        do {

            System.out.println("\n===== HOTEL ROOM BOOKING SYSTEM =====");
            System.out.println("1. Check in");
            System.out.println("2. View All Rooms");
            System.out.println("3. Search by Status");
            System.out.println("4. Search by Room Type");
            System.out.println("5. Update Booking");
            System.out.println("6. Check out");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nSelect Room Type");
                    System.out.println("1. Single");
                    System.out.println("2. Double");
                    System.out.println("3. Deluxe");
                    System.out.println("4. Suite");

                    System.out.print("Enter Choice: ");
                    int roomChoice = sc.nextInt();
                    sc.nextLine();

                    String roomType = "";

                    switch (roomChoice) {
                        case 1:
                            roomType = "Single";
                            break;
                        case 2:
                            roomType = "Double";
                            break;
                        case 3:
                            roomType = "Deluxe";
                            break;
                        case 4:
                            roomType = "Suite";
                            break;
                        default:
                            System.out.println("Invalid Room Type!");
                            continue;
                    }

                    manager.showAvailableRooms(roomType);

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Guest Name: ");
                    String guestName = sc.nextLine();

                    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                            .appendPattern("dd-MM-uuuu")
                            .toFormatter()
                            .withResolverStyle(ResolverStyle.STRICT);

                    String date;

                    while (true) {

                        System.out.print("Check-In Date (dd-MM-yyyy): ");
                        date = sc.nextLine();

                        try {
                            LocalDate.parse(date, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date! Please enter a valid date.");
                        }
                    }

                    manager.bookRoom(roomNo, guestName, date);
                    break;

                case 2:
                    manager.viewAllRooms();
                    break;

                case 3:

                    System.out.print("Enter Status: ");
                    String s = sc.nextLine();
                    manager.searchByStatus(s);
                    break;

                case 4:

                    System.out.print("Enter Room Type: ");
                    String t = sc.nextLine();
                    manager.searchByType(t);
                    break;

                case 5:

                    System.out.print("Enter Room Number: ");
                    int updateNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Guest Name: ");
                    String g = sc.nextLine();

                    System.out.print("New Room Type: ");
                    String rt = sc.nextLine();

                    System.out.print("New Check-In Date: ");
                    String d = sc.nextLine();

                    manager.updateBooking(updateNo, g, rt, d);
                    break;

                case 6:

                    System.out.print("Enter Room Number: ");
                    int remove = sc.nextInt();

                    manager.checkOut(remove);
                    break;

                case 7:
                    System.out.println("\n========================================");
                    System.out.println(" Thank you for using our Hotel Room Booking System!!!");
                    System.out.println("          Have a Great Day!");
                    System.out.println("========================================");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}