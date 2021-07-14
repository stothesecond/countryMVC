package com.example.mvcproj.controller;

import com.example.mvcproj.model.Country;
import com.example.mvcproj.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/countries")
public class CountryListController {
  CountryService countryService;

  @GetMapping("/{country_id}")
  public ModelAndView viewAbout(@PathVariable(name = "country_id") int country_id) {
    ModelAndView modelAndView = new ModelAndView();

    Optional<Country> countryOptional = countryService.findById(country_id);
    if (countryOptional.isPresent()) {
      modelAndView.setViewName("country_info");
      Country country = countryOptional.get();
      modelAndView.addObject("country", country);
    } else {
      modelAndView.setViewName("no_country");
      modelAndView.addObject("id", country_id);
    }
    return modelAndView;
  }

  @GetMapping
  public ModelAndView viewAbout() {
    ModelAndView modelAndView = new ModelAndView("all_countries");
    modelAndView.addObject("countries", countryService.findAll());
    return modelAndView;
  }

  @Autowired
  public void setCountryService(CountryService countryService) {
    this.countryService = countryService;
  }

  public CountryService getCountryService() {
    return countryService;
  }
}
