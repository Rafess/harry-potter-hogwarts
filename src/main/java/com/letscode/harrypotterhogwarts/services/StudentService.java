package com.letscode.harrypotterhogwarts.services;

import com.letscode.harrypotterhogwarts.client.GetHouseInfo;
import com.letscode.harrypotterhogwarts.client.GetHouseKey;
import com.letscode.harrypotterhogwarts.dto.StudentRequest;
import com.letscode.harrypotterhogwarts.dto.StudentResponse;
import com.letscode.harrypotterhogwarts.dto.client.HouseInfo;
import com.letscode.harrypotterhogwarts.dto.client.HouseKey;
import com.letscode.harrypotterhogwarts.entities.Student;
import com.letscode.harrypotterhogwarts.exceptions.StudentNotFoundException;
import com.letscode.harrypotterhogwarts.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GetHouseInfo getHouseInfo;
    private final GetHouseKey getHouseKey;


    public StudentResponse create(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setSerie(student.getSerie());
        HouseKey houseKey = getHouseKey.execute();
        student.setHouseKey(houseKey.getSortingHatChoice());
        studentRepository.save(student);
        return StudentResponse.toResponse(student);
    }

    public StudentResponse getStudent(Long id) {
       Student student = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        HouseInfo houseInfo = getHouseInfo.execute(student.getHouseKey());
       return StudentResponse.fromRequest(student, houseInfo);
    }
}
