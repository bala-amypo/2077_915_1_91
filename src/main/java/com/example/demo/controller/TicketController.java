package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Ticket Controller")
public class TicketController {

    @PostMapping
    public String createTicket(@RequestBody Object ticket) {
        return "Ticket created";
    }

    @GetMapping
    public String listTickets() {
        return "List tickets";
    }

    @GetMapping("/{id}")
    public String getTicket(@PathVariable Long id) {
        return "Ticket " + id;
    }
}
