package web.and.mobile.midterm.library.model.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "books")
@Data
public class Books {

    @Transient
    public static final String SEQUENCE_NAME = "books_sequence";

    @Id
    private int id;

    private String name;
    private String category;
    private String author;
    private int takenNotTaken;
    private List<Comment> comments;

    public Books(String name, String category, String author, int takenNotTaken) {
        this(name, category, author, takenNotTaken, new ArrayList<>(1));
    }

    public Books(String name, String category, String author, int takenNotTaken, List<Comment> comments) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.takenNotTaken = takenNotTaken;
        this.comments = comments;
    }

    public Books() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTakenNotTaken() {
        return takenNotTaken;
    }

    public void setTakenNotTaken(int takenNotTaken) {
        this.takenNotTaken = takenNotTaken;
    }
}
