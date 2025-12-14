package org.devary.table.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jakarta.enterprise.context.ApplicationScoped;
import org.devary.table.TableContext;

import java.io.InputStream;

@ApplicationScoped
public class ContextLoader {
    private final ObjectMapper mapper =
            new ObjectMapper(new YAMLFactory());

    public TableContext load(InputStream is) {
        if (is == null) {
            throw new IllegalArgumentException("Input stream is null");
        }

        try {
            return mapper.readValue(is, TableContext.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load context ", e);
        }
    }

}
