package util;
import lombok.experimental.UtilityClass;

import java.time.*;
import java.time.format.DateTimeFormatter;


@UtilityClass
public class DateTimeUtil {


    private final DateTimeFormatter ISO_FORMATTER =
            DateTimeFormatter.ISO_INSTANT;



    /**
     * Current UTC time.
     */
    public Instant nowUtc() {

        return Instant.now();

    }



    /**
     * Format Instant to ISO string.
     */
    public String formatIso(Instant instant) {

        if (instant == null) {
            return null;
        }

        return ISO_FORMATTER.format(instant);

    }



    /**
     * Parse ISO date.
     */
    public Instant parseIso(String value) {

        if (value == null || value.isBlank()) {
            return null;
        }

        return Instant.parse(value);

    }



    /**
     * Convert Instant to LocalDateTime.
     */
    public LocalDateTime toLocalDateTime(
            Instant instant
    ) {

        if (instant == null) {
            return null;
        }


        return LocalDateTime.ofInstant(
                instant,
                ZoneOffset.UTC
        );

    }



    /**
     * Convert LocalDateTime to Instant.
     */
    public Instant toInstant(
            LocalDateTime dateTime
    ) {

        if (dateTime == null) {
            return null;
        }


        return dateTime.toInstant(
                ZoneOffset.UTC
        );

    }

}