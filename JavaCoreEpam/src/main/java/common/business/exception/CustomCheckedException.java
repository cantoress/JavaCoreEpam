package common.business.exception;

public abstract class CustomCheckedException extends Exception {
    protected int code;

    public CustomCheckedException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CustomCheckedException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }
}
