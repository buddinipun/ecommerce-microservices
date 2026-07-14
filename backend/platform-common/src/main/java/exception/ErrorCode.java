package exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum ErrorCode {


    // Common errors

    INTERNAL_SERVER_ERROR(
            "COMMON_001",
            "Internal server error"
    ),


    VALIDATION_ERROR(
            "COMMON_002",
            "Validation failed"
    ),


    UNAUTHORIZED(
            "COMMON_003",
            "Unauthorized access"
    ),


    FORBIDDEN(
            "COMMON_004",
            "Access forbidden"
    ),



    RESOURCE_NOT_FOUND(
            "COMMON_005",
            "Resource not found"
    ),


    DUPLICATE_RESOURCE(
            "COMMON_006",
            "Resource already exists"
    );


    private final String code;

    private final String message;

}