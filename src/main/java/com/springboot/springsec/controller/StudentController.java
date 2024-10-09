package com.springboot.springsec.controller;


import com.springboot.springsec.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "40", "kenny"),
            new Student(2, "50", "debrice")
    ));


    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("student")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }
}
