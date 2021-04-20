package web.and.mobile.midterm.library.model.service;


import web.and.mobile.midterm.library.model.entity.Students;

public interface StudentsService {


    void register(Students students);

    int login(String email, String pass);

}
