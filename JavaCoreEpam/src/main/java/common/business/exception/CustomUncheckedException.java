package common.business.exception;

public class CustomUncheckedException extends RuntimeException {
    protected int code;

    public CustomUncheckedException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CustomUncheckedException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }
}
