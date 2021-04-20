package web.and.mobile.midterm.library.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;


public interface BooksWS {
    ResponseEntity ByName(String bookName);

    ResponseEntity ByCategory(String category);

    ResponseEntity ByAuthor(String author);

    ResponseEntity listOfBooks();

    ResponseEntity comment(Integer studentId, Integer bookId, String content);

    ResponseEntity getBookById(Integer bookId);
}
