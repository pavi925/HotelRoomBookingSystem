import java.util.ArrayList;

public class HotelManager {

    private ArrayList<Room> rooms = new ArrayList<>();

    public HotelManager() {

        // Single Rooms
        rooms.add(new Room(101, "Single", "Available"));
        rooms.add(new Room(102, "Single", "Available"));
        rooms.add(new Room(103, "Single", "Available"));

        // Double Rooms
        rooms.add(new Room(201, "Double", "Available"));
        rooms.add(new Room(202, "Double", "Available"));

        // Deluxe Rooms
        rooms.add(new Room(301, "Deluxe", "Available"));
        rooms.add(new Room(302, "Deluxe", "Available"));

        // Suite Rooms
        rooms.add(new Room(401, "Suite", "Available"));
        rooms.add(new Room(402, "Suite", "Available"));
    }

    // ---------------- BOOK ROOM ----------------

    public void bookRoom(int roomNo, String guestName, String checkInDate) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                if (room.getStatus().equalsIgnoreCase("Booked")) {
                    System.out.println("\nThis room is already booked.");
                    return;
                }

                room.setGuestName(guestName);
                room.setCheckInDate(checkInDate);
                room.setStatus("Booked");

                System.out.println("\n==========================================");
                System.out.println("          BOOKING CONFIRMED");
                System.out.println("==========================================");
                System.out.println("Guest Name    : " + guestName);
                System.out.println("Room Number   : " + room.getRoomNo());
                System.out.println("Room Type     : " + room.getRoomType());
                System.out.println("Check-In Date : " + checkInDate);
                System.out.println("Status        : " + room.getStatus());
                System.out.println("==========================================");
                System.out.println("Thank you for choosing our hotel!");
                return;
            }
        }

        System.out.println("Room not found.");
    }

    // ---------------- VIEW ALL ROOMS ----------------

    public void viewAllRooms() {

        if (rooms.isEmpty()) {
            System.out.println("No Records Found.");
            return;
        }

        System.out.println("\n==========================================");
        System.out.println("             ALL ROOMS");
        System.out.println("==========================================");

        System.out.printf("%-10s %-15s %-15s%n",
                "Room No", "Room Type", "Status");

        System.out.println("------------------------------------------");

        for (Room room : rooms) {
            displayRoom(room);
        }

        System.out.println("==========================================");
    }

    // ---------------- DISPLAY AVAILABLE ROOMS ----------------

    public void showAvailableRooms(String type) {

        boolean found = false;

        System.out.println("\n==========================================");
        System.out.println("      AVAILABLE " + type.toUpperCase() + " ROOMS");
        System.out.println("==========================================");

        System.out.printf("%-10s %-15s %-15s%n",
                "Room No", "Room Type", "Status");

        System.out.println("------------------------------------------");

        for (Room room : rooms) {

            if (room.getRoomType().equalsIgnoreCase(type)
                    && room.getStatus().equalsIgnoreCase("Available")) {

                displayRoom(room);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No " + type + " rooms are available.");
        }

        System.out.println("==========================================");
    }

    // ---------------- CHECK ROOM AVAILABILITY ----------------

    public boolean isRoomAvailable(int roomNo) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                if (room.getStatus().equalsIgnoreCase("Available")) {
                    return true;
                }

                System.out.println("\nThis room is already booked.");
                return false;
            }
        }

        System.out.println("\nRoom not found.");
        return false;
    }

    // ---------------- DISPLAY ROOM ----------------

    private void displayRoom(Room room) {

        System.out.printf("%-10d %-15s %-15s%n",
                room.getRoomNo(),
                room.getRoomType(),
                room.getStatus());
    }
    // ---------------- SEARCH BY STATUS ----------------

    public void searchByStatus(String status) {

        boolean found = false;

        System.out.println("\n==========================================");
        System.out.println("           SEARCH BY STATUS");
        System.out.println("==========================================");
        System.out.println("Status : " + status);
        System.out.println("------------------------------------------");

        System.out.printf("%-10s %-15s %-15s%n",
                "Room No", "Room Type", "Status");
        System.out.println("------------------------------------------");

        for (Room room : rooms) {

            if (room.getStatus().equalsIgnoreCase(status)) {
                displayRoom(room);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Rooms Found.");
        }

        System.out.println("==========================================");
    }


    // ---------------- SEARCH BY ROOM TYPE ----------------

    public void searchByType(String type) {

        boolean found = false;

        System.out.println("\n==========================================");
        System.out.println("         SEARCH BY ROOM TYPE");
        System.out.println("==========================================");
        System.out.println("Room Type : " + type);
        System.out.println("------------------------------------------");

        System.out.printf("%-10s %-15s %-15s%n",
                "Room No", "Room Type", "Status");
        System.out.println("------------------------------------------");

        for (Room room : rooms) {

            if (room.getRoomType().equalsIgnoreCase(type)) {
                displayRoom(room);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Rooms Found.");
        }

        System.out.println("==========================================");
    }


    // ---------------- CANCEL BOOKING ----------------

    public void cancelBooking(int roomNo) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                if (room.getStatus().equalsIgnoreCase("Available")) {
                    System.out.println("\nNo booking exists for Room " + roomNo + ".");
                    return;
                }

                room.setGuestName("-");
                room.setCheckInDate("-");
                room.setStatus("Available");

                System.out.println("\n==========================================");
                System.out.println("        BOOKING CANCELLED");
                System.out.println("==========================================");
                System.out.println("Room Number : " + roomNo);
                System.out.println("Status      : Available");
                System.out.println("==========================================");
                return;
            }
        }

        System.out.println("Room Not Found.");
    }


    // ---------------- CHECK OUT ----------------

    public void checkOut(int roomNo) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                if (room.getStatus().equalsIgnoreCase("Available")) {
                    System.out.println("\nRoom is already available.");
                    return;
                }

                room.setGuestName("-");
                room.setCheckInDate("-");
                room.setStatus("Available");

                System.out.println("\n==========================================");
                System.out.println("          CHECK OUT SUCCESSFUL");
                System.out.println("==========================================");
                System.out.println("Room Number : " + roomNo);
                System.out.println("Status      : Available");
                System.out.println("==========================================");
                return;
            }
        }

        System.out.println("Room Not Found.");
    }
}