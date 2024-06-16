package DataBase;

import java.util.Date;

public class Guest {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String phone;
    private String email;

    public Guest(int id, String firstName, String lastName, Date birthDate, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

