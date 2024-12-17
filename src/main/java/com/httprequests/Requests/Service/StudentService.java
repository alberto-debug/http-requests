package com.httprequests.Requests.Service;

import com.httprequests.Requests.Repository.StudentRepository;
import com.httprequests.Requests.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    //Register Student
    public Student registerStudent(Student student){
        return studentRepository.save(student);
    }

    //Get All students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //Get Student by id
    public Optional<Student> getStuentById(String id){
        return studentRepository.findById(id);
    }

    //Get Student by email
    public Student getStudentByEmal(String email){
        return studentRepository.findByEmail(email);
    }

    //Delete Student By id
    public boolean deleteStudentById(String id){
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
