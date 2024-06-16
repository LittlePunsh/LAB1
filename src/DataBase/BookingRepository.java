package DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    private Connection connection;

    public BookingRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try {
            String query = "SELECT * FROM Booking";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int guestId = resultSet.getInt("guest_id");
                int roomId = resultSet.getInt("room_id");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                double totalCost = resultSet.getDouble("total_cost");

                Booking booking = new Booking(id, guestId, roomId, startDate, endDate, totalCost);
                bookings.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public void createBooking(Booking booking) {
        try {
            String query = "INSERT INTO Booking (guest_id, room_id, start_date, end_date, total_cost) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, booking.getGuestId());
            statement.setInt(2, booking.getRoomId());
            statement.setDate(3, new java.sql.Date(booking.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(booking.getEndDate().getTime()));
            statement.setDouble(5, booking.getTotalCost());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBooking(Booking booking) {
        try {
            String query = "UPDATE Booking SET guest_id = ?, room_id = ?, start_date = ?, end_date = ?, total_cost = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, booking.getGuestId());
            statement.setInt(2, booking.getRoomId());
            statement.setDate(3, new java.sql.Date(booking.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(booking.getEndDate().getTime()));
            statement.setDouble(5, booking.getTotalCost());
            statement.setInt(6, booking.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBooking(int bookingId) {
        try {
            String query = "DELETE FROM Booking WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, bookingId);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
