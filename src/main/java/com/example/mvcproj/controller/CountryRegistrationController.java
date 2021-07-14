package com.example.mvcproj.controller;

import com.example.mvcproj.service.CountryService;
import com.example.mvcproj.validation.dto.CountryRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/new_country")
public class CountryRegistrationController {
  CountryService countryService;

  @ModelAttribute("country")
  public CountryRegistrationDto countryRegistrationDto() {
    return new CountryRegistrationDto();
  }

  @GetMapping
  public String newCountryPage(Model model) {
    return "new_country";
  }

  @PostMapping
  public String addCountry(
      @ModelAttribute("country") @Valid CountryRegistrationDto countryDto,
      BindingResult result
  ) {
    boolean existing = countryService.findByName(countryDto.getName()).isPresent();
    if (existing) {
      result.rejectValue("name", null, "There is already an country with that name!");
    }
    if (result.hasErrors()) {
      return "new_country";
    }

    countryService.save(countryDto);
    return "redirect:/countries";
  }

  @Autowired
  public void setCountryService(CountryService countryService) {
    this.countryService = countryService;
  }

  public CountryService getCountryService() {
    return countryService;
  }
}
