package web.and.mobile.midterm.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import web.and.mobile.midterm.library.model.entity.Books;
import web.and.mobile.midterm.library.model.entity.Comment;

@Repository
public interface CommentsRepository extends MongoRepository<Comment, Integer> {
}
