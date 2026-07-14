package audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@Configuration
@EnableJpaAuditing(
        auditorAwareRef = "auditorProvider",
        dateTimeProviderRef = "dateTimeProvider"
)
public class JpaAuditConfig {

    @Bean
    public AuditorAware<UUID> auditorProvider() {

        return new AuditAwareImpl();

    }

    @Bean
    public DateTimeProvider dateTimeProvider() {

        return new DateTimeProviderImpl();

    }

}