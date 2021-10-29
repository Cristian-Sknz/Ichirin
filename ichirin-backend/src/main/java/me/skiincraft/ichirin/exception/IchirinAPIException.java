package me.skiincraft.ichirin.exception;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class IchirinAPIException extends RuntimeException {

    private MessageSource messageSource;

    public IchirinAPIException(String message) {
        super(message);
    }

    public IchirinAPIException(String message, MessageSource source) {
        super(message);
        this.messageSource = source;
    }

    public IchirinAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public IchirinAPIException(String message, MessageSource source, Throwable cause) {
        super(message, cause);
        this.messageSource = source;
    }

    @Override
    public String getMessage() {
        return (messageSource == null) ? super.getMessage()
                : messageSource.getMessage(super.getMessage(), null, super.getMessage(), Locale.getDefault());
    }
}
