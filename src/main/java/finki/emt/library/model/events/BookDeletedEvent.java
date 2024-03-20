package finki.emt.library.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;


@Getter
public class BookDeletedEvent extends ApplicationEvent {
    private LocalDateTime occurredOn;
    public BookDeletedEvent(Object source) {
        super(source);
        this.occurredOn = LocalDateTime.now();
    }

    public BookDeletedEvent(Object source, LocalDateTime when) {
        super(source);
        this.occurredOn = when;
    }
}
