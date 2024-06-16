package DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicalExaminationRepository {
    private Connection connection;

    public MedicalExaminationRepository(Connection connection) {
        this.connection = connection;
    }

    public List<MedicalExamination> getAllMedicalExaminations() {
        List<MedicalExamination> examinations = new ArrayList<>();
        try {
            String query = "SELECT * FROM MedicalExamination";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int guestId = resultSet.getInt("guest_id");
                Date examinationDate = resultSet.getDate("examination_date");
                String doctorNotes = resultSet.getString("doctor_notes");

                MedicalExamination examination = new MedicalExamination(id, guestId, examinationDate, doctorNotes);
                examinations.add(examination);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return examinations;
    }

    public void createMedicalExamination(MedicalExamination examination) {
        try {
            String query = "INSERT INTO MedicalExamination (guest_id, examination_date, doctor_notes) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, examination.getGuestId());
            statement.setDate(2, new java.sql.Date(examination.getExaminationDate().getTime()));
            statement.setString(3, examination.getDoctorNotes());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMedicalExamination(MedicalExamination examination) {
        try {
            String query = "UPDATE MedicalExamination SET guest_id = ?, examination_date = ?, doctor_notes = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, examination.getGuestId());
            statement.setDate(2, new java.sql.Date(examination.getExaminationDate().getTime()));
            statement.setString(3, examination.getDoctorNotes());
            statement.setInt(4, examination.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMedicalExamination(int examinationId) {
        try {
            String query = "DELETE FROM MedicalExamination WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, examinationId);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
