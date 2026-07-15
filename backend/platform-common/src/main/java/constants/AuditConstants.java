package constants;

import java.util.UUID;

/**
 * Constants used for auditing.
 */
public final class AuditConstants {

    private AuditConstants() {
    }

    /**
     * Temporary system user.
     * Will be replaced by authenticated user once JWT is integrated.
     */
    public static final UUID SYSTEM_USER =
            UUID.fromString("00000000-0000-0000-0000-000000000001");

    public static final String CREATED_BY = "createdBy";

    public static final String UPDATED_BY = "updatedBy";

    public static final String CREATED_AT = "createdAt";

    public static final String UPDATED_AT = "updatedAt";

}