package com.example.mvcproj.validation.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.mvcproj.validation.annotations.PasswordMatches;

@PasswordMatches
public class UserRegistrationDto {
  @NotNull
  @NotEmpty
  String username;

  @NotNull
  @NotEmpty
  String password;
  String confirmPass;

  @NotNull
  @NotEmpty
  @Email
  String email;

  @NotNull
  @NotEmpty
  String fullName;

  public UserRegistrationDto() {
  }

  public UserRegistrationDto(String username, String password, String confirmPass, String email, String fullName) {
    this.username = username;
    this.password = password;
    this.confirmPass = confirmPass;
    this.email = email;
    this.fullName = fullName;
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

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPass() {
    return this.confirmPass;
  }

  public void setConfirmPass(String confirmPass) {
    this.confirmPass = confirmPass;
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

  public UserRegistrationDto username(String username) {
    setUsername(username);
    return this;
  }

  public UserRegistrationDto password(String password) {
    setPassword(password);
    return this;
  }

  public UserRegistrationDto confirmPass(String confirmPass) {
    setConfirmPass(confirmPass);
    return this;
  }

  public UserRegistrationDto email(String email) {
    setEmail(email);
    return this;
  }

  public UserRegistrationDto fullName(String fullName) {
    setFullName(fullName);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof UserRegistrationDto)) {
      return false;
    }
    UserRegistrationDto userRegistrationDto = (UserRegistrationDto) o;
    return Objects.equals(username, userRegistrationDto.username)
        && Objects.equals(password, userRegistrationDto.password)
        && Objects.equals(confirmPass, userRegistrationDto.confirmPass)
        && Objects.equals(email, userRegistrationDto.email) && Objects.equals(fullName, userRegistrationDto.fullName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, confirmPass, email, fullName);
  }

  @Override
  public String toString() {
    return "{" + " username='" + getUsername() + "'" + ", password='" + getPassword() + "'" + ", confirmPass='"
        + getConfirmPass() + "'" + ", email='" + getEmail() + "'" + ", fullName='" + getFullName() + "'" + "}";
  }

}
