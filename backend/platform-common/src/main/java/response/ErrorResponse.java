package response;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Map;


@Getter
@Builder
public class ErrorResponse {


    private final boolean success;

    private final String errorCode;

    private final String message;

    private final String path;

    private final Instant timestamp;

    private final Map<String,String> details;



    public static ErrorResponse of(
            String errorCode,
            String message,
            String path
    ) {

        return ErrorResponse.builder()
                .success(false)
                .errorCode(errorCode)
                .message(message)
                .path(path)
                .timestamp(Instant.now())
                .build();

    }



    public static ErrorResponse validation(
            String message,
            String path,
            Map<String,String> errors
    ) {

        return ErrorResponse.builder()
                .success(false)
                .errorCode("VALIDATION_ERROR")
                .message(message)
                .path(path)
                .details(errors)
                .timestamp(Instant.now())
                .build();

    }

}
