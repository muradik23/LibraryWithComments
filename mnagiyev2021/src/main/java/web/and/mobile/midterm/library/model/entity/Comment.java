package web.and.mobile.midterm.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "comment")
public class Comment {

    @Transient
    public static final String SEQUENCE_NAME = "comments_sequence";

    @Id
    private int id;

    private String commentAuthor;

    private Integer bookId;

    private String commentContent;

    public Comment(String commentAuthor, Integer bookId, String commentContent) {
        this.commentAuthor = commentAuthor;
        this.bookId = bookId;
        this.commentContent = commentContent;
    }

}
