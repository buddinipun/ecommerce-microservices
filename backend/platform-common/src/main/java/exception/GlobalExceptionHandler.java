package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import response.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(
            BaseException exception,
            HttpServletRequest request
    ) {


        log.error(
                "Application error: {}",
                exception.getMessage()
        );


        ErrorResponse response =
                ErrorResponse.of(
                        exception.getErrorCode().getCode(),
                        exception.getMessage(),
                        request.getRequestURI()
                );


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);

    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception exception,
            HttpServletRequest request
    ) {


        log.error(
                "Unexpected error",
                exception
        );


        ErrorResponse response =
                ErrorResponse.of(
                        ErrorCode.INTERNAL_SERVER_ERROR.getCode(),
                        ErrorCode.INTERNAL_SERVER_ERROR.getMessage(),
                        request.getRequestURI()
                );


        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);

    }


}