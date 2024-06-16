package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProcedureRepository {
    private Connection connection;

    public ProcedureRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Procedure> getAllProcedures() {
        List<Procedure> procedures = new ArrayList<>();
        try {
            String query = "SELECT * FROM Procedure";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                Procedure procedure = new Procedure(id, name, description);
                procedures.add(procedure);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procedures;
    }

    public void createProcedure(Procedure procedure) {
        try {
            String query = "INSERT INTO Procedure (name, description) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, procedure.getName());
            statement.setString(2, procedure.getDescription());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProcedure(Procedure procedure) {
        try {
            String query = "UPDATE Procedure SET name = ?, description = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, procedure.getName());
            statement.setString(2, procedure.getDescription());
            statement.setInt(3, procedure.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProcedure(int procedureId) {
        try {
            String query = "DELETE FROM Procedure WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, procedureId);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
