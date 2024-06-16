package DataBase;

public class Room {
    private int id;
    private String roomType;
    private double costPerDay;

    public Room(int id, String roomType, double costPerDay) {
        this.id = id;
        this.roomType = roomType;
        this.costPerDay = costPerDay;
    }

    public int getId() {
        return id;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getCostPerDay() {
        return costPerDay;
    }
}

