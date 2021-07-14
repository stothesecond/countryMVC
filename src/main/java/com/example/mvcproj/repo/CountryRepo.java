package com.example.mvcproj.repo;

import com.example.mvcproj.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
  Collection<Country> getCountriesByPopulationGreaterThan(int lowerBound);

  @Query("select c from Country c where c.population < :upper_bound")
  Collection<Country> countriesWithPopLowerThan(@Param("upper_bound") int upperBound);

  @Modifying
  @Query("delete from Country c where locate(c.name, :substr) > 0")
  void deleteCountriesWithNameContaining(String substr);

  Optional<Country> findCountryByNameIs(String name);
}
