package com.example.controller;

import com.example.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
 @GetMapping
  public String start(){
    return "Hello, User!";
  }

}
