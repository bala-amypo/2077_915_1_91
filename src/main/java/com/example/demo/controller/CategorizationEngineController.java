package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engine")
public class CategorizationEngineController {

  private final CategorizationEngineService engineService;

  public CategorizationEngineController(CategorizationEngineService engineService) {
    this.engineService = engineService;
  }

  @PostMapping("/categorize/{ticketId}")
  public Ticket categorizeTicket(@PathVariable Long ticketId) {
    return engineService.categorizeTicket(ticketId);
  }

  @GetMapping("/logs/ticket/{ticketId}")
  public List<CategorizationLog> getLogsForTicket(@PathVariable Long ticketId) {
    return engineService.getLogsForTicket(ticketId);
  }

  @GetMapping("/logs/{logId}")
  public CategorizationLog getLog(@PathVariable Long logId) {
    return engineService.getLog(logId);
  }
}
