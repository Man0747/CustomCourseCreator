package com.CustomCourseCreator.Controller;

import com.CustomCourseCreator.Dto.ChatBotDto;
import com.CustomCourseCreator.Dto.PromptDto;
import com.CustomCourseCreator.Entity.ChatBot;
import com.CustomCourseCreator.Entity.Prompt;
import com.CustomCourseCreator.Entity.PromptResponse;
import com.CustomCourseCreator.Repository.ChatBotRepo;
import com.CustomCourseCreator.Repository.PromptRepo;
import com.CustomCourseCreator.Repository.PromptResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    ChatBotRepo chatBotRepo;

    @Autowired
    PromptRepo promptRepo;

    @Autowired
    PromptResponseRepo promptResponseRepo;

    @GetMapping("/alone")
    public ResponseEntity<Object> userAlone(){
        return ResponseEntity.ok("USER alone can access this Api only");
    }

    // Endpoint for creating new ChatBot
    @PostMapping("/chatbots")
    public ResponseEntity<Object> createChatBot(@RequestBody ChatBotDto chatBotDto){

        // Creating new ChatBot Entity
        ChatBot chatBot = new ChatBot();

        // Assigning values to ChatBot Entity
        chatBot.setSourceUrls(chatBotDto.getSourceUrls());
        chatBot.setDescription(chatBotDto.getDescription());
        System.out.println("\nSaved :"+chatBot);

        // Saving ChatBot Entity
        chatBotRepo.save(chatBot);

        return ResponseEntity.ok("ok");
    }

    // Endpoint for updating a ChatBot
    @PutMapping("/chatbots/{chatBotId}")
    public ResponseEntity<Object> updateChatBot(@RequestBody ChatBotDto chatBotDto,@PathVariable Integer chatBotId){

        // Fetching ChatBot
        ChatBot chatBot =  null;
        try {
            chatBot = this.chatBotRepo.getReferenceById(chatBotId);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        // Assigning updated values to ChatBot
        chatBot.setSourceUrls(chatBotDto.getSourceUrls());
        chatBot.setDescription(chatBotDto.getDescription());
        System.out.println("\nUpdated :"+chatBot);

        // Saving ChatBot
        chatBotRepo.save(chatBot);

        return ResponseEntity.ok("ok");
    }

    // Endpoint to delete ChatBot
    @DeleteMapping("/chatbots/{chatBotId}")
    public ResponseEntity<Object> deleteChatBot(@PathVariable Integer chatBotId){

        // Fetching ChatBot
        ChatBot chatBot =  null;
        try {
            chatBot = this.chatBotRepo.getReferenceById(chatBotId);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

        // Deleting ChatBot
        this.chatBotRepo.delete(chatBot);

        return ResponseEntity.ok("ok");
    }

    // Endpoint for creating Prompt
    @PostMapping("/chatbots/{chatBotId}/prompt")
    public ResponseEntity<Object> addPrompt(@PathVariable Integer chatBotId, @RequestBody PromptDto promptDto){

        // Creating new Prompt and PromptResponse Entity
        Prompt prompt = new Prompt();
        PromptResponse promptResponse = new PromptResponse();

        // Fetching ChatBot Entity
        ChatBot chatBot =  null;
        try {
            chatBot = this.chatBotRepo.getReferenceById(chatBotId);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

        // Assigning values to the new entity
        prompt.setPromptText(promptDto.getPromptText());
        promptResponse.setResponseText("trial response");
        prompt.setPromptResponse(promptResponse);

        // Adding prompt to ChatBot
        chatBot.addPrompt(prompt);

        // Saving ChatBot and other Entities
        promptResponseRepo.save(promptResponse);
        promptRepo.save(prompt);
        chatBotRepo.save(chatBot);

        return ResponseEntity.ok(promptResponse);
    }

}
