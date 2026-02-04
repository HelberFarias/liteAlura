package com.example.litearula.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;


public class DataConverter implements IConverteDados {
    private final ObjectMapper mapper = new ObjectMapper();

    public DataConverter() {
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public <T> T parseJson(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
