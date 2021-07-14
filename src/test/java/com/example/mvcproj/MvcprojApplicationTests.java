package com.example.mvcproj;

import com.example.mvcproj.model.Country;
import com.example.mvcproj.service.CountryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MvcprojApplicationTests {
  @Autowired
  CountryServiceImpl countryService;

  @Test
  @Transactional
  void contextLoads() {
    Country country = new Country("MyCountry", 1000000, "MyCapital", 1900);
    countryService.add(country);
    System.out.println(country.toString());
    countryService.updateCountry(
        c -> new Country(
            c.getName(),
        c.getPopulation() + 10000,
            c.getCapital(),
            c.getYearFounded() + 2
        ),
        country.getId()
    );
    System.out.println(country.toString());
    countryService.deleteById(country.getId());
    for (Country c : countryService.findAll()) {
      System.out.println(c.toString());
    }
  }

}
