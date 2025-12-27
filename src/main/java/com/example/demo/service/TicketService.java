package com.example.demo.service;

import com.example.demo.dto.CreateTicketRequest;
import com.example.demo.model.Ticket;

public interface TicketService {
    Ticket createTicket(CreateTicketRequest request);
}
