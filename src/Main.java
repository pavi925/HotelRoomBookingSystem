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

            System.out.println("\n==========================================");
            System.out.println("      HOTEL ROOM BOOKING SYSTEM");
            System.out.println("==========================================");
            System.out.println();
            System.out.println("1. Check In");
            System.out.println("2. View All Rooms");
            System.out.println("3. Search by Status");
            System.out.println("4. Search by Room Type");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Check out");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Check Out");
            System.out.println("7. Exit");
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n==========================================");
                    System.out.println("              CHECK IN");
                    System.out.println("==========================================");
                    System.out.println();
                    System.out.println("Select Room Type");
                    System.out.println("------------------------------------------");
                    System.out.println("1. Single");
                    System.out.println("2. Double");
                    System.out.println("3. Deluxe");
                    System.out.println("4. Suite");
                    System.out.println("------------------------------------------");
                    System.out.print("Enter Your Choice: ");
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

                    if (!manager.isRoomAvailable(roomNo)) {
                        break;
                    }

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
                            LocalDate checkInDate = LocalDate.parse(date, formatter);

                            if (checkInDate.isBefore(LocalDate.now())) {
                                System.out.println("Check-in date cannot be in the past.");
                                continue;
                            }

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

                    System.out.println("\n==========================================");
                    System.out.println("          SEARCH BY STATUS");
                    System.out.println("==========================================");
                    System.out.println("1. Available");
                    System.out.println("2. Booked");
                    System.out.println("------------------------------------------");
                    System.out.print("Enter Your Choice: ");

                    int statusChoice = sc.nextInt();
                    sc.nextLine();

                    String status = "";

                    switch (statusChoice) {

                        case 1:
                            status = "Available";
                            break;

                        case 2:
                            status = "Booked";
                            break;

                        default:
                            System.out.println("Invalid Status!");
                            continue;
                    }

                    manager.searchByStatus(status);
                    break;

                case 4:

                    System.out.println("\n==========================================");
                    System.out.println("        SEARCH BY ROOM TYPE");
                    System.out.println("==========================================");
                    System.out.println();
                    System.out.println("1. Single");
                    System.out.println("2. Double");
                    System.out.println("3. Deluxe");
                    System.out.println("4. Suite");
                    System.out.println();
                    System.out.println("------------------------------------------");
                    System.out.print("Enter Your Choice: ");

                    int typeChoice = sc.nextInt();
                    sc.nextLine();

                    String type = "";

                    switch (typeChoice) {

                        case 1:
                            type = "Single";
                            break;

                        case 2:
                            type = "Double";
                            break;

                        case 3:
                            type = "Deluxe";
                            break;

                        case 4:
                            type = "Suite";
                            break;

                        default:
                            System.out.println("Invalid Room Type!");
                            continue;
                    }

                    manager.searchByType(type);
                    break;

                case 5:

                    System.out.print("Enter Room Number to Cancel Booking: ");
                    int cancelRoom = sc.nextInt();

                    manager.cancelBooking(cancelRoom);
                    System.out.println("\n==========================================");
                    System.out.println("          CANCEL BOOKING");
                    System.out.println("==========================================");

                    System.out.print("Enter Room Number: ");
                    int cancelRoom = sc.nextInt();
                    sc.nextLine();

                    manager.cancelBooking(cancelRoom);
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