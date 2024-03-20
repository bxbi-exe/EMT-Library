package finki.emt.library.service.impl;

import finki.emt.library.model.Country;
import finki.emt.library.model.exceptions.InvalidCountryIdException;
import finki.emt.library.repository.CountryRepository;
import finki.emt.library.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> delete(Long id) {
        Country country = findById(id);
        countryRepository.delete(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> update(Long id, String name, String continent) {
        Country country = findById(id);
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }
}
