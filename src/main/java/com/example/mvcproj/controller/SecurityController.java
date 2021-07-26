package com.example.mvcproj.controller;

import com.example.mvcproj.service.UserService;
import com.example.mvcproj.validation.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SecurityController {
  UserService userService;

  @ModelAttribute("user")
  public UserRegistrationDto userDto() {
    return new UserRegistrationDto();
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  public UserService getUserService() {
    return this.userService;
  }

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }
}
