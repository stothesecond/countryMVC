package com.example.mvcproj.service;

import com.example.mvcproj.model.Country;
import com.example.mvcproj.validation.dto.CountryRegistrationDto;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

public interface CountryService {
  Collection<Country> findAll();

  Optional<Country> findById(int id);

  Optional<Country> findByName(String name);

  void deleteById(int id);

  void updateCountry(Function<Country, Country> updateFunc, int id);

  Country convert(CountryRegistrationDto countryRegistrationDto);

  void add(Country c);

  void save(CountryRegistrationDto countryDto);
}
