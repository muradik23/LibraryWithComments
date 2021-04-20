package web.and.mobile.midterm.library.model.service;

import org.springframework.http.ResponseEntity;
import web.and.mobile.midterm.library.model.entity.Books;

import java.util.List;

public interface BooksService {


    List<Books> allBooks();

    List<Books> byCategory(String category);

    List<Books> byAuthor(String author);

    Books byName(String name);

    Integer comment(Integer studentId, Integer bookId, String content);

    Books findBookById(Integer bookId);

}
