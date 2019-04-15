package order.search;

import common.business.search.BaseSearchCondition;

public class OrderSearchCondition extends BaseSearchCondition<Long> {

    private Long countryId;
    private Long cityId;
    private Long userId;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean searchByUserId() {
        return userId != null;
    }

    public boolean searchByCountryId() {
        return countryId != null;
    }

    public boolean searchByCityId() {
        return cityId != null;
    }
}
