package com.example.faa.controller;

import com.example.faa.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/user/{userId}/tickets/{ticketId}/isAvailable")
    private Mono<Boolean> isTicketAvailable(@PathVariable long userId, @PathVariable long ticketId){
        return ticketService.isTicketExistForUser(userId, ticketId);
    }

    @GetMapping("/user/{userId}/baggage/isCheckedIn")
    private Mono<Boolean> isBaggageAvailable(@PathVariable long userId,
                                            @RequestParam long destId,
                                            @RequestParam long baggageId){
        return ticketService.isBaggageCheckedIn(userId, destId, baggageId);
    }
}
