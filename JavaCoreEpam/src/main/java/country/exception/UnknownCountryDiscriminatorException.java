package country.exception;


import common.business.exception.CustomUncheckedException;


public class UnknownCountryDiscriminatorException extends CustomUncheckedException {
    public UnknownCountryDiscriminatorException(String message, int code) {
        super(message, code);
    }

    public UnknownCountryDiscriminatorException(String message, Throwable cause, int code) {
        super(message, cause, code);
    }

    public UnknownCountryDiscriminatorException(CountryExceptionInformation inf) {
        super(inf.getDescription(), inf.getCode());
    }
}
