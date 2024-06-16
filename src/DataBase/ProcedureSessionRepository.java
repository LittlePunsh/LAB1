package DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProcedureSessionRepository {
    private Connection connection;

    public ProcedureSessionRepository(Connection connection) {
        this.connection = connection;
    }

    public List<ProcedureSession> getAllProcedureSessions() {
        List<ProcedureSession> procedureSessions = new ArrayList<>();
        try {
            String query = "SELECT * FROM ProcedureSession";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int bookingId = resultSet.getInt("booking_id");
                int procedureId = resultSet.getInt("procedure_id");
                Date sessionDate = resultSet.getDate("session_date");
                int duration = resultSet.getInt("duration");
                String resultNotes = resultSet.getString("result_notes");

                ProcedureSession procedureSession = new ProcedureSession(id, bookingId, procedureId, sessionDate, duration, resultNotes);
                procedureSessions.add(procedureSession);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procedureSessions;
    }

    public void createProcedureSession(ProcedureSession procedureSession) {
        try {
            String query = "INSERT INTO ProcedureSession (booking_id, procedure_id, session_date, duration, result_notes) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, procedureSession.getBookingId());
            statement.setInt(2, procedureSession.getProcedureId());
            statement.setDate(3, new java.sql.Date(procedureSession.getSessionDate().getTime()));
            statement.setInt(4, procedureSession.getDuration());
            statement.setString(5, procedureSession.getResultNotes());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProcedureSession(ProcedureSession procedureSession) {
        try {
            String query = "UPDATE ProcedureSession SET booking_id = ?, procedure_id = ?, session_date = ?, duration = ?, result_notes = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, procedureSession.getBookingId());
            statement.setInt(2, procedureSession.getProcedureId());
            statement.setDate(3, new java.sql.Date(procedureSession.getSessionDate().getTime()));
            statement.setInt(4, procedureSession.getDuration());
            statement.setString(5, procedureSession.getResultNotes());
            statement.setInt(6, procedureSession.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProcedureSession(int procedureSessionId) {
        try {
            String query = "DELETE FROM ProcedureSession WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, procedureSessionId);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
