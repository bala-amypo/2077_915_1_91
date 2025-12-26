package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/categorize")
@Tag(name = "Categorization Engine Controller")
public class CategorizationEngineController {

    @PostMapping("/run/{ticketId}")
    public String categorizeTicket(@PathVariable Long ticketId) {
        return "Ticket categorized: " + ticketId;
    }

    @GetMapping("/logs/{ticketId}")
    public String getLogsByTicket(@PathVariable Long ticketId) {
        return "Logs for ticket: " + ticketId;
    }

    @GetMapping("/log/{id}")
    public String getLogById(@PathVariable Long id) {
        return "Log id: " + id;
    }
}
