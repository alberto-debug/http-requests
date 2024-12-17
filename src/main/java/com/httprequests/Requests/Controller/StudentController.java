package com.httprequests.Requests.Controller;

import com.httprequests.Requests.Repository.StudentRepository;
import com.httprequests.Requests.Service.StudentService;
import com.httprequests.Requests.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //register student
    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student){

        Student registeredStudent = studentService.registerStudent(student);
        return ResponseEntity.ok(registeredStudent);
    }

    //Get all Students
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }


    // Fetch by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentsById(@PathVariable String id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //Delete Students by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable String id){
        boolean deleted = studentService.deleteStudentById(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
