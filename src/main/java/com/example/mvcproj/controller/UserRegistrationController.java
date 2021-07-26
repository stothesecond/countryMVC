package com.example.mvcproj.controller;

import javax.validation.Valid;

import com.example.mvcproj.model.User;
import com.example.mvcproj.service.UserService;
import com.example.mvcproj.validation.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {
  private UserService userService;

  @ModelAttribute("user")
  public UserRegistrationDto userRegistrationDto() {
    return new UserRegistrationDto();
  }

  @GetMapping
  public String register(Model model) {
    return "register";
  }

  @PostMapping
  public String registerAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult res) {
    User existingUsername = userService.findByUsername(userDto.getUsername()).orElse(null);
    User existingEmail = userService.findByEmail(userDto.getEmail()).orElse(null);
    if (existingUsername != null) {
      res.rejectValue("username", null, "Someone else has that username.");
    }
    if (existingEmail != null) {
      res.rejectValue("email", null, "Someone else is already using that email.");
    }
    if (res.hasErrors()) {
      return "register";
    }

    userService.save(userDto);
    return "redirect:/register?success";
  }

  public UserService getUserService() {
    return this.userService;
  }

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

}
