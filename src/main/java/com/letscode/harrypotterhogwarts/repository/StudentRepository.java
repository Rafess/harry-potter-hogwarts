package com.letscode.harrypotterhogwarts.repository;

import com.letscode.harrypotterhogwarts.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
