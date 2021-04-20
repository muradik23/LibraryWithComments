package web.and.mobile.midterm.library.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "students")
public class Students {
    @Transient
    public static final String SEQUENCE_NAME = "students_sequence";

    @Id
    private int id;

    private String nameSurname;


    private String password;

    private String email;


    public Students() {
    }

    public Students(String nameSurname, String password, String email) {
        this.nameSurname = nameSurname;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
