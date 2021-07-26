package com.example.mvcproj.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.mvcproj.model.User;
import com.example.mvcproj.repo.UserRepo;
import com.example.mvcproj.validation.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private UserRepo userRepo;

  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username).orElse(null);
    if (user == null) {
      throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
  }

  @Override
  public List<User> all() {
    return userRepo.findAll();
  }

  @Override
  public Optional<User> findById(Integer id) {
    return userRepo.findById(id);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepo.findByEmail(email);
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return userRepo.findByUsername(username);
  }

  @Override
  public void deleteById(Integer id) {
    userRepo.deleteById(id);
  }

  @Override
  public User updateUser(User user, Integer id) {
    return userRepo.save(user.id(id));
  }

  @Override
  public User add(User user) {
    return userRepo.save(user.id(null));
  }

  @Override
  public User save(UserRegistrationDto userDto) {
    User user = new User();
    user.setEmail(userDto.getEmail());
    user.setUsername(userDto.getUsername());
    user.setFullName(userDto.getFullName());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    return userRepo.save(user);
  }

  @Autowired
  public void setUserRepo(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public UserRepo getUserRepo() {
    return userRepo;
  }

  @Autowired
  public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public BCryptPasswordEncoder getPasswordEncoder() {
    return passwordEncoder;
  }
}
