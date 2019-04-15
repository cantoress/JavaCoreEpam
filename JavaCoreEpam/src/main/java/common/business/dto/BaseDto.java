package common.business.dto;

public abstract class BaseDto<ID> {
    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}