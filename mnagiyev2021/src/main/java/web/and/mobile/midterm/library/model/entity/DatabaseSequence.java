package web.and.mobile.midterm.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// this is for generating mongodb keys. there's no annotation for it
@Document(collection = "database_sequences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;


}
