package me.skiincraft.ichirin.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Autowired
    public ControllerExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NotNull HttpHeaders headers,
                                                                  HttpStatus status, @NotNull WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", status.value());

        List<ObjectNode> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> {
                    ObjectNode node = new ObjectMapper().createObjectNode();
                    node.put("field", x.getField());
                    node.put("message",  messageSource.getMessage(Optional.ofNullable(x.getDefaultMessage())
                            .orElse("validation.default.message"), null, Locale.getDefault()));
                    return node;
                }).collect(Collectors.toList());

        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }

}
