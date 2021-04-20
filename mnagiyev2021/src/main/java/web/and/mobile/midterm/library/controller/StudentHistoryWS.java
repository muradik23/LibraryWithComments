package web.and.mobile.midterm.library.controller;

import org.springframework.http.ResponseEntity;

public interface StudentHistoryWS {

    ResponseEntity pickup(int bookId, int studentId);

    ResponseEntity dropoff(int studentHistoryId);

    ResponseEntity currentPickUP(int studentId);

    ResponseEntity wholeHistory(int studentId);

}
