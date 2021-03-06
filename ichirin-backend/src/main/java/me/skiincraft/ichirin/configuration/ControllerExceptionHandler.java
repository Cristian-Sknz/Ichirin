package me.skiincraft.ichirin.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import me.skiincraft.ichirin.exception.IchirinAPIException;
import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler implements AuthenticationEntryPoint {

    private final ObjectMapper mapper;
    private final MessageSource messageSource;
    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @Autowired
    public ControllerExceptionHandler(ObjectMapper mapper, MessageSource messageSource) {
        this.mapper = mapper;
        this.messageSource = messageSource;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDeniedException(HttpServletRequest req,
                                              HttpServletResponse res,
                                              Exception e) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        HttpStatus status = HttpStatus.FORBIDDEN;
        node.put("authentication", "Bearer");
        node.put("message", e.getMessage());
        node.put("timestamp", OffsetDateTime.now(Clock.systemUTC()).toString());

        sendResponse(node, status, req, res);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest req) {
        ObjectNode node = mapper.createObjectNode();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        node.put("timestamp", OffsetDateTime.now(Clock.systemUTC()).toString());
        node.put("status", status.value());
        node.put("message", messageSource.getMessage("exception.internal.error", null, Locale.getDefault()));

        if (req instanceof ServletWebRequest) {
            node.put("path", ((ServletWebRequest) req).getRequest().getServletPath());
        }
        logger.error("Internal error: ", e);
        return new ResponseEntity<>(node, status);
    }

    public void handleAuthenticationException(HttpServletRequest req,
                                              HttpServletResponse res,
                                              Exception e) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        node.put("authentication", "basic");
        node.put("message", e.getMessage());
        node.put("timestamp", OffsetDateTime.now(Clock.systemUTC()).toString());

        sendResponse(node, status, req, res);
    }

    @ExceptionHandler(IchirinAPIException.class)
    public void handleIchirinAPIException(HttpServletRequest req,
                                          HttpServletResponse res,
                                          IchirinAPIException e) throws IOException {
        ObjectNode node = mapper.createObjectNode();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        node.put("status", status.value());
        node.put("message", e.getMessage());
        node.put("timestamp", OffsetDateTime.now(Clock.systemUTC()).toString());


        logger.error("Internal error: ", e);
        sendResponse(node, status, req, res);
    }

    @ExceptionHandler(IchirinNotFoundException.class)
    public void handleIchirinNotFoundException(HttpServletRequest req,
                                             HttpServletResponse res,
                                               IchirinNotFoundException e) throws IOException {
        ObjectNode node = mapper.createObjectNode();
        HttpStatus status = HttpStatus.NOT_FOUND;
        node.put("timestamp", OffsetDateTime.now(Clock.systemUTC()).toString());
        node.put("status", status.value());
        node.put("message", e.getMessage());

        sendResponse(node, status, req, res);
    }

    /* Override methods */
    @Override
    public void commence(HttpServletRequest req,
                         HttpServletResponse res,
                         AuthenticationException authException) throws IOException {
        this.handleAuthenticationException(req, res, authException);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        ObjectNode node = mapper.createObjectNode();
        node.put("timestamp", OffsetDateTime.now(Clock.systemUTC()).toString());
        node.put("status", status.value());
        node.put("message", getMessage("validation.message"));

        ArrayNode array = mapper.createArrayNode();
        List<ObjectNode> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> {
                    ObjectNode object = new ObjectMapper().createObjectNode();
                    object.put("field", error.getField());
                    object.put("message",  messageSource.getMessage(Optional.ofNullable(error.getDefaultMessage())
                            .orElse("validation.default.message"), null, Locale.getDefault()));
                    return object;
                }).collect(Collectors.toList());

        array.addAll(errors);
        node.set("errors", array);
        if (request instanceof ServletWebRequest) {
            node.put("path", ((ServletWebRequest) request).getRequest().getServletPath());
        }

        return new ResponseEntity<>(node, headers, status);
    }

    private void sendResponse(ObjectNode node,
                              HttpStatus status,
                              HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.setStatus(status.value());

        node.put("path", req.getServletPath());
        mapper.writeValue(res.getWriter(), node);
    }

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }
}
