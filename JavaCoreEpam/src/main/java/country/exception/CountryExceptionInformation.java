package country.exception;

public enum CountryExceptionInformation {
    DELETE_USED_COUNTRY(40, "You can't delete the country that is already used in the order!"),
    UNKNOWN_COUNTRY_DISCRIMINATOR(60, "The country is neither hot nor cold!");

    private int code;
    private String description;

    CountryExceptionInformation(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
