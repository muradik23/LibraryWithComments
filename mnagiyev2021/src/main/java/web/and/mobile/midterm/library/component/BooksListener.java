package web.and.mobile.midterm.library.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import web.and.mobile.midterm.library.model.entity.Books;
import web.and.mobile.midterm.library.model.service.mongodb.SequenceGeneratorService;

@Component
public class BooksListener extends AbstractMongoEventListener<Books> {
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public void studentsModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Books> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId((int) sequenceGenerator.generateSequence(Books.SEQUENCE_NAME));
        }
    }
}
