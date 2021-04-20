package web.and.mobile.midterm.library.model.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.and.mobile.midterm.library.controller.impl.StudentsWSImpl;
import web.and.mobile.midterm.library.model.entity.StudentHistory;
import web.and.mobile.midterm.library.model.service.StudentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.and.mobile.midterm.library.repository.StudentHistoryRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentHistoryImpl implements StudentHistoryService {
    protected static Logger logger = LoggerFactory.getLogger(StudentsWSImpl.class);

    @Autowired
    private StudentHistoryRepository studentHistoryRepository;

    @Override
    public String pick(int bookId, int userId) {
        try {


            StudentHistory studentHistory = new StudentHistory();
            studentHistory.setBookId(bookId);
            studentHistory.setUserId(userId);
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "dd/MM/yyyy");
            Date date1 = formatter.parse(formatter.format(new Date()));

            studentHistory.setPickUp(date1);
            studentHistoryRepository.save(studentHistory);

            return "DONE";
        } catch (ParseException e) {
            logger.info(e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    public String drop(int studentHistoryID) {
        try {


            StudentHistory studentHistory = studentHistoryRepository.findById(studentHistoryID).get();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "dd/MM/yyyy");
            Date date1 = formatter.parse(formatter.format(new Date()));

            studentHistory.setDropOff(date1);

            return "DONE";
        } catch (ParseException e) {
            logger.info(e.getMessage());

            return e.getMessage();

        }

    }

    @Override
    public List<StudentHistory> currentlyPickUp(int userId) throws ParseException {


        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd/MM/yyyy");
        Date date1 = formatter.parse(formatter.format(new Date()));

        return studentHistoryRepository.findAllByUserIdAndPickUp(userId, date1);

    }

    @Override
    public List<StudentHistory> wholeHistory(int userId) {
        return studentHistoryRepository.findAllByUserId(userId);
    }


}
