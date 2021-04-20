package web.and.mobile.midterm.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web.and.mobile.midterm.library.model.entity.Books;
import web.and.mobile.midterm.library.model.entity.Comment;
import web.and.mobile.midterm.library.model.entity.Students;
import web.and.mobile.midterm.library.repository.BooksRepository;
import web.and.mobile.midterm.library.repository.CommentsRepository;
import web.and.mobile.midterm.library.repository.StudentsRepository;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	StudentsRepository studentsRepository;

	@Autowired
	BooksRepository booksRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);





	}


	@Override
	public void run(String... args) throws Exception {
		studentsRepository.save(new Students("Barry Burd", "123", "barry@java.com"));
		studentsRepository.save(new Students("Kathy Sierra", "123", "kathy@java.com"));
		studentsRepository.save(new Students("Joshua Bloch", "123", "joshua@java.com"));
		studentsRepository.save(new Students("Herbert Schiltd", "123", "herbert@java.com"));
		studentsRepository.save(new Students("Robert Cecil", "123", "robert@java.com"));
		studentsRepository.save(new Students("De Niro", "123", "deniro@java.com"));

		booksRepository.save(new Books("Java for Dummies", "Programming", "Barry Burd", 0 ));
		booksRepository.save(new Books("Head Start Java", "Programming", "Kathy Sierra", 0));
		booksRepository.save(new Books("Effective Java", "Programming", "Joshua Bloch", 0));
		booksRepository.save(new Books("Thinking in Java", "Programming", "Herbert Schiltd", 0));
		booksRepository.save(new Books("Clean Code", "Programming", "Robert Cecil", 0));
	}
}
