package com.CustomCourseCreator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PythonApiService {

    @Autowired
    private RestTemplate restTemplate;

    public String postToExternalApi(String url, Map<String, String> requestPayload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(requestPayload, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        return response.getBody();
    }

    public ResponseEntity<Void> deleteFromExternalApi(String url) {
        ResponseEntity<Void> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                Void.class
        );

        return response;
    }

    public ResponseEntity<Void> deleteFromExternalApiWithPayload(String url, Object payload) {
        RestTemplate restTemplate = new RestTemplate();

        // Create headers if needed (can be customized)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Create the HttpEntity with the payload
        HttpEntity<Object> entity = new HttpEntity<>(payload, headers);

        // Make the DELETE request with the payload
        ResponseEntity<Void> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                entity,
                Void.class
        );

        return response;
    }

}
