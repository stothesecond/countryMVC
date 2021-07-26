package com.example.mvcproj.service;

import java.util.List;
import java.util.Optional;

import com.example.mvcproj.model.User;
import com.example.mvcproj.validation.dto.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  List<User> all();

  Optional<User> findById(Integer id);

  Optional<User> findByEmail(String email);

  Optional<User> findByUsername(String username);

  void deleteById(Integer id);

  User updateUser(User user, Integer id);

  User add(User user);

  User save(UserRegistrationDto userDto);
}
