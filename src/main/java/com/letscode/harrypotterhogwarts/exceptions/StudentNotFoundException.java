package com.letscode.harrypotterhogwarts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException() {
        super("The Student informed does not exists at Hogwarts School of Magic");
    }
}
