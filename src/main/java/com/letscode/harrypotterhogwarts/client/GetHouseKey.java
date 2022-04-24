package com.letscode.harrypotterhogwarts.client;

import com.letscode.harrypotterhogwarts.dto.client.HouseInfo;
import com.letscode.harrypotterhogwarts.dto.client.HouseKey;
import com.letscode.harrypotterhogwarts.exceptions.HouseNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class GetHouseKey {
    @Value("${houseKey.student}")
    private String url;
    private String uri = "sortinghat";
    public HouseKey execute() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<HouseKey> houseKeyResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, HouseKey.class, uri);
        if (houseKeyResponseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new HouseNotFoundException();
        }
        houseKeyResponseEntity.getStatusCode();
        return houseKeyResponseEntity.getBody();


    }
}
