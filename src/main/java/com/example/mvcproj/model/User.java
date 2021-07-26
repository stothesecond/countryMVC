package com.example.mvcproj.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Integer id;

  @Column(name = "username", nullable = false, unique = true)
  String username;

  @Column(name = "password", nullable = false)
  String password;

  @Column(name = "email", nullable = false, unique = true)
  String email;

  @Column(name = "full_name", nullable = false)
  String fullName;

  public User() {
  }

  public User(Integer id, String username, String password, String email, String fullName) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.fullName = fullName;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String encodedPassword) {
    this.password = encodedPassword;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public User id(Integer id) {
    setId(id);
    return this;
  }

  public User username(String username) {
    setUsername(username);
    return this;
  }

  public User password(String password) {
    setPassword(password);
    return this;
  }

  public User email(String email) {
    setEmail(email);
    return this;
  }

  public User fullName(String fullName) {
    setFullName(fullName);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password)
        && Objects.equals(email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, email);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", password='" + getPassword() + "'"
        + ", email='" + getEmail() + "'" + ", fullName='" + getFullName() + "'" + "}";
  }
}
