package web.and.mobile.midterm.library.controller;

import org.springframework.web.bind.annotation.PathVariable;
import web.and.mobile.midterm.library.model.entity.Students;
import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;

public interface StudentsWS {
    ResponseEntity login(String email, String password) throws NoSuchAlgorithmException;

    ResponseEntity register(Students students) throws NoSuchAlgorithmException;

}
