package com.CustomCourseCreator.Dto;

public class SourceDto {

    private String sourceUrl;

    public SourceDto() {
    }

    public SourceDto(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
