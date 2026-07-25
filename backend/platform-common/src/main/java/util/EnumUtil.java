package util;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

import enums.common.LookupEnum;

@UtilityClass
public class EnumUtil {

    /**
     * Find enum by code.
     */
    public static <E extends Enum<E> & LookupEnum> E fromCode(
            Class<E> enumClass,
            String code
    ) {

        if (code == null || code.isBlank()) {
            return null;
        }

        return Arrays.stream(enumClass.getEnumConstants())
                .filter(value -> value.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    /**
     * Check whether a code exists.
     */
    public static <E extends Enum<E> & LookupEnum> boolean isValidCode(
            Class<E> enumClass,
            String code
    ) {

        return fromCode(enumClass, code) != null;
    }

}