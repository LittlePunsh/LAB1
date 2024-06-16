package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SanatoriumDatabaseH2 {
    private static final String URL = "jdbc:h2:./Sanatorium";
    private static final String USER = "LittlePunsh";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT g.first_name AS guest_first_name, g.last_name AS guest_last_name, r.room_type AS room_type, " +
                    "b.start_date AS start_date, b.end_date AS end_date, p.name AS procedure_name, " +
                    "ps.session_date AS session_date, ps.duration AS duration, ps.result_notes AS result_notes " +
                    "FROM Guest g " +
                    "JOIN Booking b ON g.id = b.guest_id " +
                    "JOIN Room r ON b.room_id = r.id " +
                    "JOIN ProcedureSession ps ON b.id = ps.booking_id " +
                    "JOIN Procedure p ON ps.procedure_id = p.id";

            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String firstName = resultSet.getString("guest_first_name");
                    String lastName = resultSet.getString("guest_last_name");
                    String roomType = resultSet.getString("room_type");
                    String startDate = resultSet.getString("start_date");
                    String endDate = resultSet.getString("end_date");
                    String procedureName = resultSet.getString("procedure_name");
                    String sessionDate = resultSet.getString("session_date");
                    int duration = resultSet.getInt("duration");
                    String resultNotes = resultSet.getString("result_notes");

                    System.out.printf("Гость: %s %s, Комната: %s, Дата заезда: %s, Дата выезда: %s, Процедура: %s, Дата сеанса: %s, Длительность: %d минут, Результат: %s%n",
                            firstName, lastName, roomType, startDate, endDate, procedureName, sessionDate, duration, resultNotes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
