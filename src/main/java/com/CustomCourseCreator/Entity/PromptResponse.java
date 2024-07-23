package com.CustomCourseCreator.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prompt_responses")
public class PromptResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "response_text")
    private String responseText;

    public PromptResponse() {
    }

    public PromptResponse(String responseText) {
        this.responseText = responseText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    @Override
    public String toString() {
        return "PromptResponse{" +
                "id=" + id +
                ", responseText='" + responseText + '\'' +
                '}';
    }
}
