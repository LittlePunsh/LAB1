package DataBase;

import java.util.Date;

public class ProcedureSession {
    private int id;
    private int bookingId;
    private int procedureId;
    private Date sessionDate;
    private int duration;
    private String resultNotes;

    public ProcedureSession(int id, int bookingId, int procedureId, Date sessionDate, int duration, String resultNotes) {
        this.id = id;
        this.bookingId = bookingId;
        this.procedureId = procedureId;
        this.sessionDate = sessionDate;
        this.duration = duration;
        this.resultNotes = resultNotes;
    }

    public int getId() {
        return id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getProcedureId() {
        return procedureId;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public int getDuration() {
        return duration;
    }

    public String getResultNotes() {
        return resultNotes;
    }
}
