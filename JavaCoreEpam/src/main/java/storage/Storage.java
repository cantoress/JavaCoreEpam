package storage;

import city.domain.City;
import country.domain.Country;
import order.domain.Order;
import user.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final int CAPACITY = 4;
    public static City[] cityArray = new City[CAPACITY];
    public static Country[] countryArray = new Country[CAPACITY];
    public static Order[] orderArray = new Order[CAPACITY];
    public static User[] userArray = new User[CAPACITY];

    public static List<City> cityList = new ArrayList<>();
    public static List<Country> countryList = new ArrayList<>();
    public static List<Order> orderList = new ArrayList<>();
    public static List<User> userList = new ArrayList<>();
}
