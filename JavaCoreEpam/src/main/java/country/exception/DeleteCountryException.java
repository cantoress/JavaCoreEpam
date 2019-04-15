package country.exception;

import common.business.exception.CustomUncheckedException;

public class DeleteCountryException extends CustomUncheckedException {
    public DeleteCountryException(String message, int code) {
        super(message, code);
    }

    public DeleteCountryException(String message, Throwable cause, int code) {
        super(message, cause, code);
    }

    public DeleteCountryException(CountryExceptionInformation inf) {
        super(inf.getDescription(), inf.getCode());
    }
}
