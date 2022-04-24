package com.letscode.harrypotterhogwarts.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String serie;

    private UUID houseKey;
}
