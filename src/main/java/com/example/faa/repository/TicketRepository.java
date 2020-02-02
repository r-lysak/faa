package com.example.faa.repository;

import com.example.faa.model.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TicketRepository {
    private final UserRepository userRepository;

    private List<Ticket> availTickets = List.of(
            Ticket.builder().id(1).user(userRepository.getUserById(1)).baggageId("Checked in baggage").destinationId(1).build(),
            Ticket.builder().id(2).user(userRepository.getUserById(2)).destinationId(1).build()
            );

    public Mono<Ticket> getTicketById(long id) {
        return Mono.justOrEmpty(availTickets.stream().filter(t -> t.getId() == id).findFirst());
    }

    public Mono<Boolean> isTicketExistForUser(long id, long userId) {
        return Mono.justOrEmpty(availTickets.stream()
                .filter(t -> t.getId() == id)
                .filter(t -> t.getUser().getId() == userId)
                .findFirst().isPresent());
    }

    public Flux<Ticket> findAll() {
        return Flux.fromIterable(availTickets);
    }

}
