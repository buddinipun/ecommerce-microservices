package enums.common;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountStatus implements LookupEnum {

    PENDING_VERIFICATION(
            "PENDING_VERIFICATION",
            "Pending Verification"
    ),

    ACTIVE(
            "ACTIVE",
            "Active"
    ),

    LOCKED(
            "LOCKED",
            "Locked"
    ),

    SUSPENDED(
            "SUSPENDED",
            "Suspended"
    ),

    DISABLED(
            "DISABLED",
            "Disabled"
    );

    private final String code;

    private final String description;

}