package web.and.mobile.midterm.library.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.and.mobile.midterm.library.model.entity.Students;
import web.and.mobile.midterm.library.model.service.StudentsService;
import web.and.mobile.midterm.library.repository.StudentsRepository;


@Service
public class StudentsImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;


    @Override
    public void register(Students students) {

        studentsRepository.save(students);
    }

    @Override
    public int login(String email, String pass) {
        if (studentsRepository.findFirstByEmailAndPassword(email, pass) != null) {
            return 1;
        }
        return 0;

    }
}
