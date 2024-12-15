package com.httprequests.Requests.Controller;

import com.httprequests.Requests.Service.StudentService;
import com.httprequests.Requests.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //register students
    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student){
        Student registeredStudent = studentService.registerStudent(student);
        return ResponseEntity.ok(registeredStudent);
    }

    //Get all students
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //Get students by id
   // @PathVariable Long id: Maps the id part of the URL (/{id}) to the id parameter in the method. For example, if
    // the request is GET /students/123, id will be 123.
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        Optional<Student> student = studentService.getStudentsById(id);
        return student.map(s -> new ResponseEntity<>(s,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}
