package com.matias.backend_portfolio.utils;

import org.springframework.stereotype.Component;

@Component
public class DataCleaningUtils {
    
    public static String trimToNull(String str) {
        if (str == null) return null;
        String trimmed = str.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }
    
    public static String trimToNullOrThrow(String str, String fieldName) {
        String cleaned = trimToNull(str);
        if (cleaned == null) {
            throw new IllegalArgumentException(fieldName + " cannot be empty or whitespace only");
        }
        return cleaned;
    }
}