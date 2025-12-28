package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.model.CategorizationLog;

import java.util.List;

public interface CategorizationEngineService {
    Ticket categorizeTicket(Long ticketId);
    java.util.List<CategorizationLog> getLogsForTicket(Long ticketId);
}
