package finki.emt.library.service;

import finki.emt.library.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Country findById(Long id);
    Optional<Country> save(String name, String continent);
    Optional<Country> delete(Long id);
    Optional<Country> update(Long id, String name, String continent);
}
