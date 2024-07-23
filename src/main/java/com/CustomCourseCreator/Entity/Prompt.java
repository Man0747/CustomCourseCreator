package com.CustomCourseCreator.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prompts")
public class Prompt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "prompt_text",length = 65535)
    private String promptText;

    @OneToOne(cascade = CascadeType.ALL)
    private PromptResponse promptResponse;

    public Prompt() {
    }

    public Prompt(String promptText, PromptResponse promptResponse) {
        this.promptText = promptText;
        this.promptResponse = promptResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public PromptResponse getPromptResponse() {
        return promptResponse;
    }

    public void setPromptResponse(PromptResponse promptResponse) {
        this.promptResponse = promptResponse;
    }

    @Override
    public String toString() {
        return "Prompt{" +
                "id=" + id +
                ", promptText='" + promptText + '\'' +
                ", promptResponse=" + promptResponse +
                '}';
    }
}
