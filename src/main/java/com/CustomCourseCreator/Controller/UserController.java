package com.CustomCourseCreator.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/alone")
    public ResponseEntity<Object> userAlone(){
        return ResponseEntity.ok("USER alone can access this Api only");
    }

}
