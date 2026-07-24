import java.util.ArrayList;

public class HotelManager {

    private ArrayList<Room> rooms = new ArrayList<>();

    // Add Room
    public void addRoom(Room room) {

        // Stretch Goal
        for (Room r : rooms) {
            if (r.getRoomNo() == room.getRoomNo()
                    && r.getStatus().equalsIgnoreCase("Booked")) {
                System.out.println("Room already booked!");
                return;
            }
        }

        rooms.add(room);
        System.out.println("Room Added Successfully.");
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
}
