package finki.emt.library.service.impl;

import finki.emt.library.model.Author;
import finki.emt.library.model.Book;
import finki.emt.library.model.Category;
import finki.emt.library.model.exceptions.InvalidAuthorIdException;
import finki.emt.library.model.exceptions.InvalidBookIdException;
import finki.emt.library.model.exceptions.NotEnoughNumberOfCopiesException;
import finki.emt.library.repository.AuthorRepository;
import finki.emt.library.repository.BookRepository;
import finki.emt.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookSerivceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, int availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(InvalidAuthorIdException::new);
        Book book = new Book(name, category, author, availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> delete(Long id) {
        Book book = findById(id);
        bookRepository.delete(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> update(Long id, String name, Category category, Long authorId, int availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(InvalidAuthorIdException::new);
        Book book = findById(id);
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> rentBook(Long id, int numOfCopies) {
        Book book = findById(id);
        if(book.getAvailableCopies() < numOfCopies) {
            throw new NotEnoughNumberOfCopiesException();
        }
        book.setAvailableCopies(book.getAvailableCopies() - numOfCopies);
        return Optional.of(bookRepository.save(book));
    }
}
