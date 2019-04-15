package city.exception;

import common.business.exception.CustomUncheckedException;

public class DeleteCityException extends CustomUncheckedException {
    public DeleteCityException( int code, String message) {
        super(message, code);
    }

    public DeleteCityException(int code, String message, Throwable cause) {
        super(message, cause, code);
    }

    public DeleteCityException(CityExceptionInformation inf) {
        super(inf.getDescription(), inf.getCode());
    }
}
