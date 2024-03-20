package finki.emt.library.Config;

import finki.emt.library.model.Category;
import finki.emt.library.model.Country;
import finki.emt.library.service.AuthorService;
import finki.emt.library.service.BookService;
import finki.emt.library.service.CountryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final AuthorService authorService;

    private final BookService bookService;

    private final CountryService countryService;


    @PostConstruct
    public void initData() {
        for (int i = 0; i < 5; i++) {
            countryService.save("Country" + i, "Continent" + i);
        }
        List<Long> countryIds = countryService.findAll().stream().map(Country::getId).toList();
        for (int i = 0; i < 5; i++) {
            authorService.createAuthor("Author" + i, "Surname" + i, countryIds.get(i));
        }
        List<Long> authorIds = authorService.findAll().stream().map(finki.emt.library.model.Author::getId).toList();
        List<Category> categories = List.of(Category.values());
        for (int i = 0; i < 5; i++) {
            bookService.save("Book" + i, categories.get(i), authorIds.get(i), 10);
        }
    }

}