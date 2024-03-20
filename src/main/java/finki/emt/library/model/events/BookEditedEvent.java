package finki.emt.library.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;


@Getter
public class BookEditedEvent extends ApplicationEvent {
    private LocalDateTime occurredOn;
    public BookEditedEvent(Object source) {
        super(source);
        this.occurredOn = LocalDateTime.now();
    }

    public BookEditedEvent(Object source, LocalDateTime when) {
        super(source);
        this.occurredOn = when;
    }
}
