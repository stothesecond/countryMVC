package com.example.mvcproj.controller;

import com.example.mvcproj.model.Country;
import com.example.mvcproj.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AppController {
  CountryService countryService;

  @PostMapping("/delete/{id}")
  public String deleteCountry(@PathVariable(name = "id") int countryId) {
    countryService.deleteById(countryId);
    return "redirect:/countries";
  }

  // setters and getters

  @Autowired
  public void setCountryService(CountryService countryService) {
    this.countryService = countryService;
  }

  public CountryService getCountryService() {
    return countryService;
  }
}
