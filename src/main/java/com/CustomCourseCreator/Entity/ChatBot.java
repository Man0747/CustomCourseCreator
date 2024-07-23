package com.CustomCourseCreator.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat_bots")
public class ChatBot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @ElementCollection
    @CollectionTable(name = "chat_bot_source_urls", joinColumns = @JoinColumn(name = "chat_bot_id"))
    @Column(name = "source_url")
    private List<String> sourceUrls;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Prompt> prompts;

    public ChatBot() {
    }

    public ChatBot(String description, List<String> sourceUrls, List<Prompt> prompts) {
        this.description = description;
        this.sourceUrls = sourceUrls;
        this.prompts = prompts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Prompt> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }

    public void addPrompt(Prompt prompt){
        if (this.prompts == null){
            this.prompts = new ArrayList<>();
            this.prompts.add(prompt);
        }
        else{
            this.prompts.add(prompt);
        }
    }

    @Override
    public String toString() {
        return "ChatBot{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", sourceUrls=" + sourceUrls +
                '}';
    }
}
