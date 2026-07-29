package config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class TimeZoneConfig {

    @PostConstruct
    public void init() {

        /*
         * Force JVM timezone to UTC.
         */
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

    }

}
