package constants;
/**
 * Database related constants.
 */
public final class DatabaseConstants {

    private DatabaseConstants() {
    }

    public static final String UUID_COLUMN = "BINARY(16)";

    public static final String CREATED_AT_COLUMN = "created_at";

    public static final String UPDATED_AT_COLUMN = "updated_at";

    public static final String CREATED_BY_COLUMN = "created_by";

    public static final String UPDATED_BY_COLUMN = "updated_by";

    public static final int DEFAULT_BATCH_SIZE = 50;

}