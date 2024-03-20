package finki.emt.library.service;

import finki.emt.library.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> createAuthor(String name, String surname, Long countryId);
    Optional<Author> updateAuthor(Long id, String name, String surname, Long countryId);
    Optional<Author> deleteAuthor(Long id);
    Optional<Author> findById(Long id);
}
