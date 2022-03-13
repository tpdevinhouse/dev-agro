package com.tpdevinhouse.devagro.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration
public class DataConfig {

//  Padronização data e hora no formato ISO 8601 UTC
    public static final String DATATEMPO_FORMATADO = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static LocalDateTimeSerializer LOCAL_DATATEMPO_SERIALIZER = new LocalDateTimeSerializer
            (DateTimeFormatter.ofPattern(DATATEMPO_FORMATADO));

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATATEMPO_SERIALIZER);
        return new ObjectMapper()
                .registerModule(module);
    }

}
