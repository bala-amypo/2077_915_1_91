package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;

import java.util.List;

public interface CategorizationEngineService {

    // ✅ EXACT method name expected by tests
    Ticket categorizeTicket(Long ticketId);

    CategorizationLog getLog(Long logId);

    List<CategorizationLog> getLogsForTicket(Long ticketId);
}
