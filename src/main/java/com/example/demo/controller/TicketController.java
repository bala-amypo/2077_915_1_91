package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketRepository ticketRepository;

    public TicketController(TicketService ticketService,
                            TicketRepository ticketRepository) {
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ticket getById(@PathVariable Long id) {
        return ticketService.getTicket(id);
    }
}
