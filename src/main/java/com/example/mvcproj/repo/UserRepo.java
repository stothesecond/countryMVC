package com.example.mvcproj.repo;

import java.util.Optional;

import com.example.mvcproj.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);

  Optional<User> findByUsername(String username);
}
