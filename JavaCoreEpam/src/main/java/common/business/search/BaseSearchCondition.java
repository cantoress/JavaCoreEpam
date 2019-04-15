package common.business.search;

public abstract class BaseSearchCondition<ID> {
    protected ID id;
    protected OrderDirection orderDirection;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public OrderDirection getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }
}
