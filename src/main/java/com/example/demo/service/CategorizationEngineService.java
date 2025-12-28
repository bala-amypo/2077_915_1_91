package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;

import java.util.List;

public interface CategorizationEngineService {

    // 🔴 THIS NAME MATTERS
    Ticket categorize(Long ticketId);

    CategorizationLog getLog(Long logId);

    List<CategorizationLog> getLogsForTicket(Long ticketId);
}

package com.example.demo.service;

import com.example.demo.model.Ticket;

public interface CategorizationEngineService {

    // REQUIRED by test cases
    Ticket categorizeTicket(Long ticketId);
}
