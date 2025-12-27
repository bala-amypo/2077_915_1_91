package com.example.demo.service;

import com.example.demo.model.Ticket;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    Ticket getTicket(Long id);
}
