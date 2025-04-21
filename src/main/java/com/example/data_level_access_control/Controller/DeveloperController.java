package com.example.data_level_access_control.Controller;

import com.example.data_level_access_control.model.Merchant;
import com.example.data_level_access_control.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperController {

  private final MerchantRepository merchantRepository;

  public DeveloperController(MerchantRepository merchantRepository) {
    this.merchantRepository = merchantRepository;
  }

  @GetMapping("/ping")
  public ResponseEntity<String> getAllTutorials() {
    return new ResponseEntity<>("pong", HttpStatus.OK);
  }
}
