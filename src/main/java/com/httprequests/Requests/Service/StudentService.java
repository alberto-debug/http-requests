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

    //Register a student
    public Student registerStudent(Student student){
        return studentRepository.save(student);
    }
    
    //Get all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //Get student by id
    public Optional<Student> getStudentsById(String id){
        return studentRepository.findById(id);
    }

    public Student getStudentsByEmail(String email){
        return studentRepository.findByEmail(email);
    }

}
