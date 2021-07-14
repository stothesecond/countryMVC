package com.example.mvcproj.controller;

import com.example.mvcproj.model.Country;
import com.example.mvcproj.service.CountryService;
import com.example.mvcproj.validation.dto.CountryRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/edit/{id}")
public class EditCountryController {
  CountryService countryService;

  @ModelAttribute("country")
  public CountryRegistrationDto countryRegistrationDto() {
    return new CountryRegistrationDto();
  }

  @GetMapping
  public ModelAndView editCountryPage(@PathVariable(name = "id") int countryId) {
    ModelAndView modelAndView = new ModelAndView("edit");
    Optional<Country> countryOptional = countryService.findById(countryId);
    assert (countryOptional.isPresent());
    Country country = countryOptional.get();
    modelAndView.addObject("countryObj", country);
    return modelAndView;
  }

  @PostMapping
  public String saveCountry(
      @PathVariable(name = "id") int countryId,
      @ModelAttribute("country") @Valid CountryRegistrationDto countryDto,
      BindingResult result
  ) {
    if (!countryService.findById(countryId).isPresent()) {
      throw new IllegalStateException();
    }
    if (result.hasErrors()) {
      return "redirect:/edit/" + countryId;
    }
    Country country = countryService.convert(countryDto);
    countryService.updateCountry(
        c -> country,
        country.getId()
    );
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
