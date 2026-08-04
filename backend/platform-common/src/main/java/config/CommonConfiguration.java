package config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import config.properties.OpenApiProperties;


@Configuration
@EnableConfigurationProperties(
        OpenApiProperties.class
)
public class CommonConfiguration {

}