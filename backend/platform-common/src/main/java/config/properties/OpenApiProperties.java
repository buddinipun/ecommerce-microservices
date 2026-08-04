package config.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(
        prefix = "application.api"
)
public class OpenApiProperties {

    private String title =
            "E-Commerce API";

    private String version =
            "v1";

    private String description =
            "E-Commerce Microservice API";

    private String contactName =
            "E-Commerce Platform Team";

    private String contactEmail =
            "support@ecommerce.com";

}
