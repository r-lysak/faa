package com.example.faa.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ticket {
    private long id;
    private long destinationId;
    private String baggageId;
    private User user;
}
