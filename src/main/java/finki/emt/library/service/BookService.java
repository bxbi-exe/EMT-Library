package finki.emt.library.service;

import finki.emt.library.model.Book;
import finki.emt.library.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Optional<Book> save(String name, Category category, Long authorId, int availableCopies);
    Optional<Book> delete(Long id);
    Optional<Book> update(Long id, String name, Category category, Long authorId, int availableCopies);
    Optional<Book> rentBook(Long id, int numOfCopies);
}
