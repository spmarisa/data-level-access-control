package com.example.data_level_access_control.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperController {

  @GetMapping("/ping")
  public ResponseEntity<String> getAllTutorials() {
    return new ResponseEntity<>("pong", HttpStatus.OK);
  }
}
