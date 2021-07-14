package com.example.mvcproj.service;

import com.example.mvcproj.model.Country;
import com.example.mvcproj.repo.CountryRepo;
import com.example.mvcproj.validation.dto.CountryRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CountryServiceImpl implements CountryService {
  CountryRepo countryRepo;

  @Override
  public void add(Country c) {
    countryRepo.save(c);
  }

  @Override
  public Collection<Country> findAll() {
    return countryRepo.findAll();
  }

  @Override
  public Optional<Country> findById(int id) {
    return countryRepo.findById(id);
  }

  @Override
  public void deleteById(int id) {
    countryRepo.deleteById(id);
  }

  @Override
  public void updateCountry(Function<Country, Country> updateFunc, int id) {
    countryRepo
        .findById(id)
        .map(updateFunc)
        .ifPresent(
            c -> {
              c.setId(id);
              countryRepo.save(c);
            }
        )
    ;
  }

  @Override
  public Optional<Country> findByName(String name) {
    return countryRepo.findCountryByNameIs(name);
  }

  @Override
  public Country convert(CountryRegistrationDto countryDto) {
    Country c = new Country();
    c.setName(countryDto.getName());
    c.setCapital(countryDto.getCapital());
    c.setPopulation(countryDto.getPopulation());
    c.setYearFounded(countryDto.getYearFounded());
    if (countryDto.getId() != null) {
      c.setId(countryDto.getId());
    }
    return c;
  }

  @Override
  public void save(CountryRegistrationDto countryDto) {
    countryRepo.save(convert(countryDto));
  }

  public CountryRepo getCountryRepo() {
    return countryRepo;
  }

  @Autowired
  public void setCountryRepo(CountryRepo countryRepo) {
    this.countryRepo = countryRepo;
  }
}
