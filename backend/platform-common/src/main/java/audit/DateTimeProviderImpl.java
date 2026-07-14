package audit;

import org.springframework.data.auditing.DateTimeProvider;

import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

public class DateTimeProviderImpl implements DateTimeProvider {

    @Override
    public Optional<TemporalAccessor> getNow() {

        return Optional.of(Instant.now());

    }

}