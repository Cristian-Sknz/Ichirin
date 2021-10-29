package me.skiincraft.ichirin.exception;

import org.springframework.context.MessageSource;

public class IchirinNotFoundException extends IchirinAPIException {

    public IchirinNotFoundException(String message) {
        super(message);
    }

    public IchirinNotFoundException(String message, MessageSource source) {
        super(message, source);
    }

    public IchirinNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IchirinNotFoundException(String message, MessageSource source, Throwable cause) {
        super(message, source, cause);
    }
}
