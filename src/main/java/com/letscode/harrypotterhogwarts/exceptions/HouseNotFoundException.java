package com.letscode.harrypotterhogwarts.exceptions;

public class HouseNotFoundException extends RuntimeException {
    public HouseNotFoundException() {
        super("The houseKey informed does not Exists!");
    }
}
