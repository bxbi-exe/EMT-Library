package finki.emt.library.service.impl;

import finki.emt.library.model.Author;
import finki.emt.library.model.Country;
import finki.emt.library.model.exceptions.InvalidAuthorIdException;
import finki.emt.library.model.exceptions.InvalidCountryIdException;
import finki.emt.library.repository.AuthorRepository;
import finki.emt.library.repository.CountryRepository;
import finki.emt.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> createAuthor(String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
        Author author = new Author(name, surname, country);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> updateAuthor(Long id, String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
        Author author = authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
        authorRepository.delete(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of(authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new));
    }
}
