package com.example.faa.service;

import com.example.faa.model.Ticket;
import com.example.faa.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Mono<Boolean> isTicketExistForUser(long ticketId, long userId) {
        return ticketRepository.isTicketExistForUser(ticketId, userId);
    }

    public Mono<Boolean> isBaggageCheckedIn(long userId, long destId, String baggageId) {
        return ticketRepository.findAll()
                .any(t -> t.getUser().getId() == userId
                        && t.getDestinationId() == destId
                        && t.getBaggageId().equals(baggageId));
    }

    public Mono<Ticket> getUserTicket(long ticketId, long userId) {
        return ticketRepository.getTicketById(ticketId)
                .filter(t -> t.getUser().getId() == userId);
    }
}
