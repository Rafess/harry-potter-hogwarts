package com.letscode.harrypotterhogwarts.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class HouseKey {
    @JsonProperty(value = "sorting-hat-choice")
    private UUID sortingHatChoice;
}
