package com.letscode.harrypotterhogwarts.controller;

import com.letscode.harrypotterhogwarts.dto.StudentRequest;
import com.letscode.harrypotterhogwarts.dto.StudentResponse;
import com.letscode.harrypotterhogwarts.services.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentResponse register(@RequestBody StudentRequest studentRequest) {
        return studentService.create(studentRequest);
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentResponse getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
}
