package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.UrgencyPolicy;

public class TicketCategorizationEngine {

    public void categorize(Category category, UrgencyPolicy policy) {
        String defaultUrgency = category.getDefaultUrgency();
        String keyword = policy.getKeyword();
        String urgencyOverride = policy.getUrgencyOverride();
        // Categorization logic here
    }
}

