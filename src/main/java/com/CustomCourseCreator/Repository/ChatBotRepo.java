package com.CustomCourseCreator.Repository;

import com.CustomCourseCreator.Entity.ChatBot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatBotRepo extends JpaRepository<ChatBot,Integer> {
}
