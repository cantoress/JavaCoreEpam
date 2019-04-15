package city.exception;

public enum CityExceptionInformation {
    DELETE_USED_CITY(1, "You can't delete the city that is already used in the order");

    private int code;
    private String description;

    CityExceptionInformation(int code, String description) {
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
