package py.gov.sigor.shared.infrastructure.bus.event.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import py.gov.sigor.shared.domain.Service;
import py.gov.sigor.shared.domain.bus.event.DomainEvent;
import py.gov.sigor.shared.domain.bus.event.EventBus;

import java.util.List;


@Primary
@Service
public class SpringApplicationEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
