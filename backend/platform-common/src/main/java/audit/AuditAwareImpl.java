package audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

public class AuditAwareImpl implements AuditorAware<UUID> {

    /**
     * Temporary system user.
     * Will be replaced with JWT authenticated user.
     */
    private static final UUID SYSTEM_USER =
            UUID.fromString("00000000-0000-0000-0000-000000000001");

    @Override
    public Optional<UUID> getCurrentAuditor() {

        return Optional.of(SYSTEM_USER);

    }

}