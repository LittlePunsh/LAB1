package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private Connection connection;

    public RoomRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            String query = "SELECT * FROM Room";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String roomType = resultSet.getString("room_type");
                double costPerDay = resultSet.getDouble("cost_per_day");

                Room room = new Room(id, roomType, costPerDay);
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public void createRoom(Room room) {
        try {
            String query = "INSERT INTO Room (room_type, cost_per_day) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, room.getRoomType());
            statement.setDouble(2, room.getCostPerDay());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRoom(Room room) {
        try {
            String query = "UPDATE Room SET room_type = ?, cost_per_day = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, room.getRoomType());
            statement.setDouble(2, room.getCostPerDay());
            statement.setInt(3, room.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(int roomId) {
        try {
            String query = "DELETE FROM Room WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, roomId);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
