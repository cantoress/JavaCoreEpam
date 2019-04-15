package user.exception;

public enum UserExceptionInformation {

    DELETE_USED_USER(1, "You can't delete the user that is already used in the order");

    private int code;
    private String description;

    UserExceptionInformation(int code, String description) {
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
