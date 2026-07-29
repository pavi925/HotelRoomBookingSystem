public class Room {

    private int roomNo;
    private String guestName;
    private String roomType;
    private String checkInDate;
    private String status;

    public Room(int roomNo, String roomType,  String status) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.status = status;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", guestName='" + guestName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}