package finki.emt.library.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.time.LocalDateTime;


@Getter
public class BookCreatedEvent extends ApplicationEvent {
    private LocalDateTime occurredOn;
    public BookCreatedEvent(Object source) {
        super(source);
        this.occurredOn = LocalDateTime.now();
    }

    public BookCreatedEvent(Object source, LocalDateTime when) {
        super(source);
        this.occurredOn = when;
    }
}
