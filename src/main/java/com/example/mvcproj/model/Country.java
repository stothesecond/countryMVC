package com.example.mvcproj.model;

import com.example.mvcproj.validation.annotations.NotAfterThisYear;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "country")
public class Country implements Serializable {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "population", nullable = false)
  private int population;

  @Column(name = "capital_name", nullable = false)
  private String capital;

  @Column(name = "year_founded", nullable = false)
  private int yearFounded;

  public Country() {
  }

  public Country(String name, int population) {
    this.name = name;
    this.population = population;
  }

  public Country(String name, int population, String capital, int yearFounded) {
    this.name = name;
    this.population = population;
    this.capital = capital;
    this.yearFounded = yearFounded;
  }

  // setters and getters

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public void setYearFounded(int yearFounded) {
    this.yearFounded = yearFounded;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPopulation() {
    return population;
  }

  public String getCapital() {
    return capital;
  }

  public int getYearFounded() {
    return yearFounded;
  }
}
