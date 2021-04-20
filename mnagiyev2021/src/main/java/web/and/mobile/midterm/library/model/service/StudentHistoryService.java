package web.and.mobile.midterm.library.model.service;

import web.and.mobile.midterm.library.model.entity.StudentHistory;

import java.text.ParseException;
import java.util.List;


public interface StudentHistoryService {


    String pick(int bookId, int userId);

    String drop(int studentHistoryID) throws ParseException;

    List<StudentHistory> currentlyPickUp(int userId) throws ParseException;

    List<StudentHistory> wholeHistory(int userId);


}
