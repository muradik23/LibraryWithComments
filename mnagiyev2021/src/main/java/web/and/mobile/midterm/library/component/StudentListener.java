package web.and.mobile.midterm.library.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import web.and.mobile.midterm.library.model.entity.Students;
import web.and.mobile.midterm.library.model.service.mongodb.SequenceGeneratorService;


@Component
public class StudentListener extends AbstractMongoEventListener<Students> {
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public void studentsModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Students> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId((int) sequenceGenerator.generateSequence(Students.SEQUENCE_NAME));
        }
    }
}
