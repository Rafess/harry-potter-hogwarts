package com.letscode.harrypotterhogwarts.dto;

import com.letscode.harrypotterhogwarts.dto.client.HouseInfo;
import com.letscode.harrypotterhogwarts.entities.Student;
import lombok.Data;

import java.util.UUID;

@Data
public class StudentResponse extends StudentRequest {
    private Long id;
    private String name;
    private String serie;
    private UUID houseKey;
    private String house;

    public static StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setName(student.getName());
        response.setId(student.getId());
        response.setSerie(student.getSerie());
        response.setHouseKey(student.getHouseKey());
        return response;
    }

    public static StudentResponse fromRequest(Student student, HouseInfo houseInfo) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setSerie(student.getSerie());
        response.setHouse(houseInfo.getName());
        return response;
    }
}
