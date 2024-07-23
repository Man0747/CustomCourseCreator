package com.CustomCourseCreator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    public ResponseEntity<String> getWithPrompt(String url, String prompt) {
        // Build the URL with the prompt parameter
        String finalUrl = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("prompt", prompt)
                .toUriString();

        // Create headers if needed (optional for GET request)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        // Create the HttpEntity (can be null for GET requests)
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(finalUrl, HttpMethod.GET, entity, String.class);
    }
}
