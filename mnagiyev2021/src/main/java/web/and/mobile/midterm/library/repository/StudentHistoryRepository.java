package web.and.mobile.midterm.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.and.mobile.midterm.library.model.entity.StudentHistory;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentHistoryRepository extends CrudRepository<StudentHistory, Integer> {


    List<StudentHistory> findAllByUserId(int userId);

    List<StudentHistory> findAllByUserIdAndPickUp(int userId, Date date);


}
