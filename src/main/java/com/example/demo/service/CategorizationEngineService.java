package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;

import java.util.List;

public interface CategorizationEngineService {

    Ticket categorizeTicket(Long ticketId);

    // REQUIRED BY TEST
    List<CategorizationLog> getLog(Long ticketId);

    // REQUIRED BY TEST
    List<CategorizationLog> getLogsForTicket(Long ticketId);
}
