package com.optimusinfo.azuresearchdemo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is used for converting JSON string into corresponding Model classes
 * 
 * @author Optimus
 */
@Component
public class RestSupport {
    protected ObjectMapper jackson = new ObjectMapper();

    protected Resource resource(String location) {
        return new ClassPathResource(location);
    }

    public <T> T readValue(String location, Class<T> type) {
        try {
            return jackson.readValue(new FileReader(resource(location).getFile()), type);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public <T> T readValueFromString(String body, Class<T> type) {
        try {
            return jackson.readValue(new StringReader(body), type);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
