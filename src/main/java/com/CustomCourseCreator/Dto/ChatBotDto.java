package com.CustomCourseCreator.Dto;

import java.util.List;

public class ChatBotDto {
    private String description;
    private List<String> sourceUrls;

    public ChatBotDto() {
    }

    public ChatBotDto(String description, List<String> sourceUrls) {
        this.description = description;
        this.sourceUrls = sourceUrls;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSourceUrls() {
        return sourceUrls;
    }

    public void setSourceUrls(List<String> sourceUrls) {
        this.sourceUrls = sourceUrls;
    }
}
