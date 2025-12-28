package com.example.demo.service;

import com.example.demo.model.CategorizationLog;

public interface CategorizationEngineService {
    CategorizationLog categorizeTicket(Long ticketId);
}
