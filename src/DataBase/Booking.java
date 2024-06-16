package DataBase;

import java.util.Date;

public class Booking {
    private int id;
    private int guestId;
    private int roomId;
    private Date startDate;
    private Date endDate;
    private double totalCost;

    public Booking(int id, int guestId, int roomId, Date startDate, Date endDate, double totalCost) {
        this.id = id;
        this.guestId = guestId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public int getGuestId() {
        return guestId;
    }

    public int getRoomId() {
        return roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }
}

