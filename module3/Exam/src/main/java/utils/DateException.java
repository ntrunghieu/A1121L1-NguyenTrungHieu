package utils;

import java.time.format.DateTimeParseException;

public class DateException extends Exception {
    public DateException() {
    }

    public DateException(String message) {
        super(message);
    }
}
