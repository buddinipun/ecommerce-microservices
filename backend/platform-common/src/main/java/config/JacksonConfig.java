package config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper mapper = new ObjectMapper();

        /*
         * Java 8+ Date & Time Support
         */
        mapper.registerModule(new JavaTimeModule());

        /*
         * Serialize LocalDateTime as ISO-8601
         */
        mapper.disable(
                SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
        );

        /*
         * Ignore unknown JSON fields
         */
        mapper.disable(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
        );

        /*
         * Ignore null values
         */
        mapper.setSerializationInclusion(
                JsonInclude.Include.NON_NULL
        );

        /*
         * Case-insensitive enum values
         */
        mapper.enable(
                MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS
        );

        /*
         * Pretty print can be enabled for development if needed.
         */
        mapper.disable(
                SerializationFeature.INDENT_OUTPUT
        );

        return mapper;
    }

}
