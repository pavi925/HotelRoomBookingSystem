import java.util.ArrayList;

public class HotelManager {

    private ArrayList<Room> rooms = new ArrayList<>();
    public HotelManager() {

        rooms.add(new Room(101, "-", "Single", "-", "Available"));
        rooms.add(new Room(102, "-", "Single", "-", "Available"));
        rooms.add(new Room(103, "-", "Single", "-", "Available"));

        rooms.add(new Room(201, "-", "Double", "-", "Available"));
        rooms.add(new Room(202, "-", "Double", "-", "Available"));

        rooms.add(new Room(301, "-", "Deluxe", "-", "Available"));
        rooms.add(new Room(302, "-", "Deluxe", "-", "Available"));

        rooms.add(new Room(401, "-", "Suite", "-", "Available"));
        rooms.add(new Room(402, "-", "Suite", "-", "Available"));

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

                System.out.println("Room booked successfully!");
                System.out.println("Have a great day!!!");
                return;
            }
        }

        System.out.println("Room not found.");
    }

    // View All Rooms
    public void viewAllRooms() {

        if (rooms.isEmpty()) {
            System.out.println("No Records Found.");
            return;
        }

        for (Room room : rooms) {
            System.out.println(room);
        }
    }
    // Available rooms
    public void showAvailableRooms(String type) {

        boolean found = false;

        System.out.println("\nAvailable " + type + " Rooms");
        System.out.println("--------------------------");

        for (Room room : rooms) {

            if (room.getRoomType().equalsIgnoreCase(type)
                    && room.getStatus().equalsIgnoreCase("Available")) {

                System.out.println("Room No : " + room.getRoomNo());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No " + type + " rooms are available.");
        }
    }

    // Search by Status
    public void searchByStatus(String status) {

        boolean found = false;

        for (Room room : rooms) {
            if (room.getStatus().equalsIgnoreCase(status)) {
                System.out.println(room);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Rooms Found.");
        }
    }

    // Search by Room Type
    public void searchByType(String type) {

        boolean found = false;

        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(type)) {
                System.out.println(room);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Rooms Found.");
        }
    }

    // Update Booking
    public void updateBooking(int roomNo,
                              String guestName,
                              String roomType,
                              String checkInDate
                              ) {

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {
                if (room.getStatus().equalsIgnoreCase("Available")) {
                    System.out.println("This room is not currently available.");
                    return;
                }

                room.setGuestName(guestName);
                room.setRoomType(roomType);
                room.setCheckInDate(checkInDate);

                System.out.println("Booking Updated Successfully.");
                return;
            }
        }

        System.out.println("Room Not Found.");
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
