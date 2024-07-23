package com.CustomCourseCreator.Repository;

import com.CustomCourseCreator.Entity.PromptResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptResponseRepo extends JpaRepository<PromptResponse, Integer> {
}
