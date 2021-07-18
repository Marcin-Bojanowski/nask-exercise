package nask.exercise.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final String FILE_NOT_FOUND_MSG="File not found";

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity handleFileNotFound(FileNotFoundException exception){
        log.error("FileNotFound thrown with message: {}, stack trace: {}", exception.getMessage(),exception.getStackTrace());
        return ResponseEntity.badRequest().body(ApiError.builder()
                .timestamp(LocalDateTime.now())
                .message(FILE_NOT_FOUND_MSG)
                .status(HttpStatus.BAD_REQUEST)
                .build());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleRuntimeException(Exception exception){
        log.error("Exception thrown with message: {}, stack trace: {}", exception.getMessage(),exception.getStackTrace());
        return ResponseEntity.badRequest().body(ApiError.builder()
                .timestamp(LocalDateTime.now())
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build());

    }

}
