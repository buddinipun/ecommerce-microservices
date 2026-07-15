package constants;
/**
 * API related constants shared across all microservices.
 */
public final class ApiConstants {

    private ApiConstants() {
    }

    public static final String API_BASE_PATH = "/api";
    public static final String API_VERSION_V1 = "/v1";

    public static final String SUCCESS_MESSAGE = "Request completed successfully";

    public static final String CREATED_MESSAGE = "Resource created successfully";

    public static final String UPDATED_MESSAGE = "Resource updated successfully";

    public static final String DELETED_MESSAGE = "Resource deleted successfully";

    public static final String DEFAULT_PAGE = "0";

    public static final String DEFAULT_SIZE = "20";

    public static final String DEFAULT_SORT = "createdAt";

    public static final String DEFAULT_SORT_DIRECTION = "DESC";

}