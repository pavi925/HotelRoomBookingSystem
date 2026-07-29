public class Room {

    private int roomNo;
    private String guestName;
    private String roomType;
    private String checkInDate;
    private String status;

    // Constructor
    public Room(int roomNo, String roomType, String status) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.status = status;
        this.guestName = "-";
        this.checkInDate = "-";
    }

    // Getters
    public int getRoomNo() {
        return roomNo;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Room No : %-5d | Room Type : %-8s | Status : %s",
                roomNo,
                roomType,
                status
        );
    }
}