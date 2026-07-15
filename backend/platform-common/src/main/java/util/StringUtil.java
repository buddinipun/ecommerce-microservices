package util;
import lombok.experimental.UtilityClass;


@UtilityClass
public class StringUtil {


    public boolean hasText(String value) {

        return value != null 
                && !value.trim().isEmpty();

    }



    public boolean isEmpty(String value) {

        return value == null 
                || value.isEmpty();

    }



    public String trimToNull(String value) {

        if (!hasText(value)) {
            return null;
        }

        return value.trim();

    }



    public String capitalize(String value) {

        if (!hasText(value)) {
            return value;
        }


        return value.substring(0,1).toUpperCase()
                + value.substring(1);

    }



    public String defaultIfBlank(
            String value,
            String defaultValue
    ) {

        return hasText(value)
                ? value
                : defaultValue;

    }

}