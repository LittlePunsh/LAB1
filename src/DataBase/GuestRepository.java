package DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestRepository {
    private Connection connection;

    public GuestRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();
        try {
            String query = "SELECT * FROM Guest";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date birthDate = resultSet.getDate("birth_date");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                Guest guest = new Guest(id, firstName, lastName, birthDate, phone, email);
                guests.add(guest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return guests;
    }

    public void createGuest(Guest guest) {
        try {
            String query = "INSERT INTO Guest (first_name, last_name, birth_date, phone, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, guest.getFirstName());
            statement.setString(2, guest.getLastName());
            statement.setDate(3, new java.sql.Date(guest.getBirthDate().getTime()));
            statement.setString(4, guest.getPhone());
            statement.setString(5, guest.getEmail());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGuest(Guest guest) {
        try {
            String query = "UPDATE Guest SET first_name = ?, last_name = ?, birth_date = ?, phone = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, guest.getFirstName());
            statement.setString(2, guest.getLastName());
            statement.setDate(3, new java.sql.Date(guest.getBirthDate().getTime()));
            statement.setString(4, guest.getPhone());
            statement.setString(5, guest.getEmail());
            statement.setInt(6, guest.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGuest(int guestId) {
        try {
            String query = "DELETE FROM Guest WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, guestId);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
