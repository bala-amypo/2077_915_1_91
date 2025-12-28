package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorize")
public class CategorizationEngineController {

    private final CategorizationEngineService engineService;

    public CategorizationEngineController(CategorizationEngineService engineService) {
        this.engineService = engineService;
    }

    @PostMapping("/run/{ticketId}")
    public Ticket categorize(@PathVariable Long ticketId) {
        return engineService.categorizeTicket(ticketId);
    }

    @GetMapping("/logs/{ticketId}")
    public List<CategorizationLog> getLogs(@PathVariable Long ticketId) {
        return engineService.getLogsForTicket(ticketId);
    }

    @GetMapping("/log/{id}")
    public CategorizationLog getLog(@PathVariable Long id) {
        return engineService.getLog(id);
    }
}
