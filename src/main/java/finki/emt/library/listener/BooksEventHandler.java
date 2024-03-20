package finki.emt.library.listener;

import finki.emt.library.model.events.BookCreatedEvent;
import finki.emt.library.model.events.BookDeletedEvent;
import finki.emt.library.model.events.BookEditedEvent;
import finki.emt.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BooksEventHandler {
    private final BookRepository bookRepository;
    @EventListener
    public void onBookCreated(BookCreatedEvent event) {
        System.out.println("Event handler for book created");
    }
    @EventListener
    public void onBookDeleted(BookDeletedEvent event) {
        System.out.println("Event handler for book deleted");
    }
    @EventListener
    public void onBookUpdated(BookEditedEvent event) {
        System.out.println("Event handler for book updated");
    }

}
