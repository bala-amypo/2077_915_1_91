package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @PostMapping
  public Ticket createTicket(@RequestBody Ticket ticket) {
    return ticketService.createTicket(ticket);
  }

  @GetMapping("/{id}")
  public Ticket getTicket(@PathVariable Long id) {
    return ticketService.getTicket(id);
  }
}
