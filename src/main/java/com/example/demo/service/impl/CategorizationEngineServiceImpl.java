package com.example.demo.service.impl;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.repository.CategorizationLogRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategorizationLogRepository logRepository,
            TicketCategorizationEngine engine
    ) {
        this.ticketRepository = ticketRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    // ==================================================
    // REQUIRED BY INTERFACE (NAME MUST MATCH)
    // ==================================================
    @Override
    public Ticket categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket not found")
                );

        engine.categorize(ticket);

        return ticketRepository.save(ticket);
    }

    // ==================================================
    // REQUIRED BY INTERFACE
    // ==================================================
    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Log not found")
                );
    }

    // ==================================================
    // REQUIRED BY INTERFACE
    // ==================================================
    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
