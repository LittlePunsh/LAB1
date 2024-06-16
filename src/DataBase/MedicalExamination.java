package DataBase;

import java.util.Date;

public class MedicalExamination {
    private int id;
    private int guestId;
    private Date examinationDate;
    private String doctorNotes;

    public MedicalExamination(int id, int guestId, Date examinationDate, String doctorNotes) {
        this.id = id;
        this.guestId = guestId;
        this.examinationDate = examinationDate;
        this.doctorNotes = doctorNotes;
    }

    public int getId() {
        return id;
    }

    public int getGuestId() {
        return guestId;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }
}

