package constants;
import java.time.ZoneOffset;

/**
 * Date and time constants.
 */
public final class DateConstants {

    private DateConstants() {
    }

    public static final String ISO_DATE_TIME_PATTERN =
            "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static final String DATE_PATTERN =
            "yyyy-MM-dd";

    public static final String DATE_TIME_PATTERN =
            "yyyy-MM-dd HH:mm:ss";

    public static final ZoneOffset DEFAULT_ZONE =
            ZoneOffset.UTC;

}