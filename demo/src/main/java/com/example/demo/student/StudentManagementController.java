package com.example.demo.student;

import com.google.common.collect.ImmutableList;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {
    private static List<Student> students = ImmutableList.of(
            Student.builder().studentId(1).studentName("James Bond").build(),
            Student.builder().studentId(2).studentName("Maria Jone").build(),
            Student.builder().studentId(3).studentName("Anna Smith").build());

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        System.out.println("getAllStudents");
        return students;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent( @RequestBody Student student){
        System.out.println("register New studnet");
        System.out.println(student);
    }
    @DeleteMapping(path="{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){System.out.println("delete a new student");
        System.out.println(studentId);
    }

    @PutMapping(path="{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId")Integer studentId,@RequestBody Student student){System.out.println(" update tudent");
        System.out.println(String.format("%s %s",studentId,student));
    }

}
