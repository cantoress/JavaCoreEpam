package user.exception;

import common.business.exception.CustomUncheckedException;

public class DeleteUserException extends CustomUncheckedException {
    public DeleteUserException(String message, int code) {
        super(message, code);
    }

    public DeleteUserException(String message, Throwable cause, int code) {
        super(message, cause, code);
    }

    public DeleteUserException(UserExceptionInformation inf) {
        super(inf.getDescription(), inf.getCode());
    }
}
