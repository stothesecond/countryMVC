package com.example.mvcproj.validation.dto;

import com.example.mvcproj.validation.annotations.NotAfterThisYear;

import javax.validation.constraints.*;

public class CountryRegistrationDto {
  private Integer id;

  @NotBlank(message = "Country cannot have no name!")
  private String name;

  @Positive(message = "Please enter a population value!")
  @Min(value = 500, message = "That's not enough for a whole country!")
  private int population;

  @NotBlank(message = "Capital must have a name!")
  @Size(min = 4, message = "That's too short a name!")
  private String capital;

  @Positive(message = "When was the country founded?")
  @NotAfterThisYear(message = "The country cannot have been founded in the future.")
  private int yearFounded;

  public CountryRegistrationDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public int getYearFounded() {
    return yearFounded;
  }

  public void setYearFounded(int yearFounded) {
    this.yearFounded = yearFounded;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
