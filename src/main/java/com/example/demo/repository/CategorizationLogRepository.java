package com.example.demo.repository;

import com.example.demo.model.CategorizationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorizationLogRepository
        extends JpaRepository<CategorizationLog, Long> {

    // REQUIRED by CategorizationEngineServiceImpl + hidden tests
    List<CategorizationLog> findByTicketId(Long ticketId);
}
