package web.and.mobile.midterm.library.model.service.impl;

import web.and.mobile.midterm.library.model.entity.Books;
import web.and.mobile.midterm.library.model.entity.Comment;
import web.and.mobile.midterm.library.model.entity.Students;
import web.and.mobile.midterm.library.model.service.BooksService;
import web.and.mobile.midterm.library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.and.mobile.midterm.library.repository.CommentsRepository;
import web.and.mobile.midterm.library.repository.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public Books byName(String bookName) {
        return booksRepository.findByName(bookName);
    }



    @Override
    public List<Books> allBooks() {
        return booksRepository.findAll();
    }

    @Override
    public List<Books> byCategory(String category) {
        return booksRepository.findAllByCategory(category);
    }

    @Override
    public List<Books> byAuthor(String author) {
        return booksRepository.findAllByAuthor(author);
    }

    // ***********************************************

    @Override
    public Integer comment(Integer studentId, Integer bookId, String content) {
        Optional<Books> books = booksRepository.findById(bookId);
        Optional<Students> students = studentsRepository.findById(studentId);
        if (books.isEmpty())
            return 0;
        if (students.isEmpty())
            return 0;

        Books books1 = books.get();
        Students student = students.get();
        books1.getComments().add(new Comment(student.getEmail(), bookId, content));

        booksRepository.save(books1);
        commentsRepository.save(new Comment(student.getEmail(), bookId, content));
        return 1;
    }

    @Override
    public Books findBookById(Integer bookId) {
        Optional<Books> booksOptional = booksRepository.findById(bookId);
        if (booksOptional.isEmpty()) {
            return null;
        } else {
            return booksOptional.get();
        }
    }

    // ***********************************************

}
