package web.and.mobile.midterm.library.repository;

import web.and.mobile.midterm.library.model.entity.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends CrudRepository<Students, Integer> {

    Students findFirstByEmailAndPassword(String email, String password);

    Optional<Students> findById(Integer id);

}
