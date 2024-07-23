package com.CustomCourseCreator.Repository;

import com.CustomCourseCreator.Entity.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepo extends JpaRepository<Prompt,Integer> {
}
