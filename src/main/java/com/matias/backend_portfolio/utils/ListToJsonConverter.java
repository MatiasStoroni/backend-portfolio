package com.matias.backend_portfolio.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter
public class ListToJsonConverter implements AttributeConverter<List<String>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    //Converts Java → DB
    @Override
    public String convertToDatabaseColumn(List<String> list) {
        try {
            return (list == null) ? "[]" : objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            throw new RuntimeException("Could not convert list to JSON", e);
        }
    }

    //Converts DB → Java
    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        try {
            return (dbData == null || dbData.trim().isEmpty())
                    ? new ArrayList<>()
                    : objectMapper.readValue(dbData, new TypeReference<List<String>>() {
                    });
        } catch (Exception e) {
            throw new RuntimeException("Could not convert JSON to list", e);
        }
    }
}