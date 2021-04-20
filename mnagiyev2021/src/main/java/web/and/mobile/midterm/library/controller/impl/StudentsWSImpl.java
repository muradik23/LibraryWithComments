package web.and.mobile.midterm.library.controller.impl;

import org.springframework.http.HttpStatus;
import web.and.mobile.midterm.library.controller.StudentsWS;
import web.and.mobile.midterm.library.model.entity.Students;

import web.and.mobile.midterm.library.model.service.StudentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.and.mobile.midterm.library.utils.MD5Hashing;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

@RestController
public class StudentsWSImpl implements StudentsWS {

    protected static Logger logger = LoggerFactory.getLogger(StudentsWSImpl.class);


    @Autowired
    private StudentsService studentsService;

    @Override
    public ResponseEntity register(@RequestBody Students students) throws NoSuchAlgorithmException {
        students.setPassword(MD5Hashing.hashing(students.getPassword()));
        studentsService.register(students);
        return new ResponseEntity("Register DONE", HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(
            @RequestHeader("email") String email,
            @RequestHeader("password") String password
    ) throws NoSuchAlgorithmException {
        if (studentsService.login(email, MD5Hashing.hashing(password)) == 1) {
            return new ResponseEntity("Logged IN", HttpStatus.OK);
        }

        return new ResponseEntity("The user is not existed in DB", HttpStatus.BAD_GATEWAY);


    }




}
