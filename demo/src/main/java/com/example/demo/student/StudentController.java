package com.example.demo.student;

import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static List<Student> students = ImmutableList.of(
            Student.builder().studentId(1).studentName("James Bond").build(),
            Student.builder().studentId(2).studentName("Maria Jone").build(),
    Student.builder().studentId(3).studentName("Anna Smith").build());

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return students
                .stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("No student found"));
    }
}
