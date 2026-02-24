package com.lanre.security_project1.controller;

import com.lanre.security_project1.Repository.StudentRepo;
import com.lanre.security_project1.dto.StudentRequest;
import com.lanre.security_project1.entity.Student;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class HelloController {
    private StudentRepo studentRepo;
    public HelloController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("/hello")
    public String hello() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication a = context.getAuthentication();
        return "Hello, " + a.getName() + "!";
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        studentRepo.save(student);

        return "Student added";
    }
}
