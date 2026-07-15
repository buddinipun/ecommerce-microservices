package util;
import lombok.experimental.UtilityClass;

import java.util.UUID;


@UtilityClass
public class UuidUtil {


    /**
     * Generate new UUID.
     */
    public UUID generate() {

        return UUID.randomUUID();

    }


    /**
     * Convert String to UUID.
     */
    public UUID fromString(String value) {

        if (isEmpty(value)) {
            return null;
        }

        try {

            return UUID.fromString(value);

        } catch (IllegalArgumentException exception) {

            return null;
        }

    }


    /**
     * Check UUID string validity.
     */
    public boolean isValid(String value) {

        if (isEmpty(value)) {
            return false;
        }

        try {

            UUID.fromString(value);

            return true;

        } catch (IllegalArgumentException exception) {

            return false;

        }

    }


    /**
     * Check UUID null.
     */
    public boolean isEmpty(UUID uuid) {

        return uuid == null;

    }


    private boolean isEmpty(String value) {

        return value == null || value.trim().isEmpty();

    }

}