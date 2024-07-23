package com.CustomCourseCreator.Dto;

public class PromptDto {

    private String promptText;

    public PromptDto() {
    }

    public PromptDto(String promptText) {
        this.promptText = promptText;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }
}
