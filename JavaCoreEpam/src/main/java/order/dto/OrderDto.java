package order.dto;

import city.dto.CityDto;
import common.business.dto.BaseDto;
import country.dto.CountryDto;
import user.dto.UserDto;

public class OrderDto extends BaseDto<Long> {

    private CountryDto country;
    private CityDto city;
    private UserDto user;

    private String description;
    private int price;

    public OrderDto() {
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
