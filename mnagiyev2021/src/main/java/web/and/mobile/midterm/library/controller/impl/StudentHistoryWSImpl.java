package web.and.mobile.midterm.library.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import web.and.mobile.midterm.library.controller.StudentHistoryWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.and.mobile.midterm.library.model.service.StudentHistoryService;

@RestController
public class StudentHistoryWSImpl implements StudentHistoryWS {
    protected static Logger logger = LoggerFactory.getLogger(StudentsWSImpl.class);

    @Autowired
    private StudentHistoryService studentHistoryService;


    @Override
    @RequestMapping(value = "/pickup", method = RequestMethod.POST)
    public ResponseEntity pickup(@RequestParam("bookID") int bookId, @RequestParam("studentID") int studentId) {
        try {

            return ResponseEntity.ok(studentHistoryService.pick(bookId, studentId));

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/dropoff", method = RequestMethod.POST)
    public ResponseEntity dropoff(@RequestParam("studentHistoryID") int studentHistoryID) {
        try {


            return new ResponseEntity(studentHistoryService.drop(studentHistoryID), HttpStatus.OK);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/currentPickUP", method = RequestMethod.GET)
    public ResponseEntity currentPickUP(@RequestHeader("userID") int userID) {
        try {


            return new ResponseEntity(studentHistoryService.currentlyPickUp(userID), HttpStatus.OK);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/allData", method = RequestMethod.GET)

    public ResponseEntity wholeHistory(@RequestHeader("userID") int userID) {
        try {


            return new ResponseEntity(studentHistoryService.wholeHistory(userID), HttpStatus.OK);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
