import java.util.ArrayList;

public class HotelManager {

    private ArrayList<Room> rooms = new ArrayList<>();
    public HotelManager() {

        rooms.add(new Room(101, "Single",  "Available"));
        rooms.add(new Room(102,  "Single", "Available"));
        rooms.add(new Room(103, "Single",  "Available"));

        rooms.add(new Room(201,  "Double",  "Available"));
        rooms.add(new Room(202, "Double",  "Available"));

        rooms.add(new Room(301,  "Deluxe",  "Available"));
        rooms.add(new Room(302,  "Deluxe",  "Available"));

        rooms.add(new Room(401,  "Suite",  "Available"));
        rooms.add(new Room(402,  "Suite",  "Available"));

    }

    public void bookRoom(int roomNo, String guestName, String checkInDate) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                if (room.getStatus().equalsIgnoreCase("Booked")) {
                    System.out.println("Room is already booked!");
                    return;
                }

                room.setGuestName(guestName);
                room.setCheckInDate(checkInDate);
                room.setStatus("Booked");

                System.out.println("\n==========================================");
                System.out.println("          BOOKING CONFIRMED");
                System.out.println("==========================================");
                System.out.println("Guest Name   : " + guestName);
                System.out.println("Room Number  : " + room.getRoomNo());
                System.out.println("Room Type    : " + room.getRoomType());
                System.out.println("Check-In Date: " + checkInDate);
                System.out.println("Status       : " + room.getStatus());
                System.out.println("==========================================");
                System.out.println("Thank you for choosing our hotel!");
                return;
            }
        }

        System.out.println("Room not found.");
    }

    public void viewAllRooms() {

        if (rooms.isEmpty()) {
            System.out.println("No Records Found.");
            return;
        }

        System.out.println("--------------------------------------------");
        System.out.printf("%-10s %-15s %-15s%n",
                "Room No", "Room Type", "Status");
        System.out.println("--------------------------------------------");

        for (Room room : rooms) {
            displayRoom(room);
        }
    }
    // Display Available Rooms by Type
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

    // check if room is available
    public boolean isRoomAvailable(int roomNo) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                if (room.getStatus().equalsIgnoreCase("Available")) {
                    return true;
                }

                System.out.println("Room is already booked!");
                return false;
            }
        }

        System.out.println("Room not found.");
        return false;
    }

    // Search Rooms by Status
    public void searchByStatus(String status) {

        boolean found = false;

        System.out.println("\n==========================================");
        System.out.println("      SEARCH BY STATUS");
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

    // Search Rooms by Type
    public void searchByType(String type) {

        boolean found = false;

        System.out.println("\n==========================================");
        System.out.println("      SEARCH BY ROOM TYPE");
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

    // Update Booking
    public void cancelBooking(int roomNo) {
    // Cancel Booking
    public void cancelBooking(int roomNo) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                if (room.getStatus().equalsIgnoreCase("Available")) {
                    System.out.println("No booking found for this room.");
                    System.out.println("No booking exists for this room.");
                    return;
                }

                room.setGuestName("-");
                room.setCheckInDate("-");
                room.setStatus("Available");
                room.setGuestName(null);
                room.setCheckInDate(null);
                room.setStatus("Available");

                System.out.println("Booking Cancelled Successfully.");
                System.out.println("\n==========================================");
                System.out.println("      BOOKING CANCELLED");
                System.out.println("==========================================");
                System.out.println("Room Number : " + roomNo);
                System.out.println("Status      : Available");
                System.out.println("==========================================");
                return;
            }
        }

        System.out.println("Room Not Found.");
    }
    private void displayRoom(Room room) {
        System.out.printf("%-10d %-15s %-15s%n",
                room.getRoomNo(),
                room.getRoomType(),
                room.getStatus());
    }

    // Check out
    public void checkOut(int roomNo) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                if (room.getStatus().equalsIgnoreCase("Available")) {
                    System.out.println("Room is already available.");
                    return;
                }

                room.setGuestName("-");
                room.setCheckInDate("-");
                room.setStatus("Available");

                System.out.println("Check-out Successful. Room is now Available.");
                return;
            }
        }

        System.out.println("Room Not Found.");
    }
}
