package web.and.mobile.midterm.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import web.and.mobile.midterm.library.model.entity.Books;
import org.springframework.stereotype.Repository;
import web.and.mobile.midterm.library.model.entity.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends MongoRepository<Books, Integer> {
    Books findByName(String name);

    List<Books> findAllByCategory(String category);

    List<Books> findAllByAuthor(String author);

    @Query("{ '_id' : ?0 }")
    Optional<Books> findById(Integer id);

}