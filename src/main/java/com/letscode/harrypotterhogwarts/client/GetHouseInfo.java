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
public class GetHouseInfo {
    @Value("${example.student}")
    private String url;

    public HouseInfo execute(UUID houseKey) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<HouseInfo> houseInfoResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, HouseInfo.class, houseKey);
        if (houseInfoResponseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new HouseNotFoundException();
        }
        houseInfoResponseEntity.getStatusCode();
        return houseInfoResponseEntity.getBody();


    }
}
