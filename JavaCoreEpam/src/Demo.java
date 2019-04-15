import city.repo.CityRepo;
import city.repo.impl.CityCollectionRepo;
import city.service.CityService;
import city.service.impl.CityDefaultService;
import country.repo.CountryRepo;
import country.repo.impl.CountryCollectionRepo;
import country.service.CountryService;
import country.service.impl.CountryDefaultService;
import order.repo.OrderRepo;
import order.repo.impl.OrderCollectionRepo;
import order.service.OrderService;
import order.service.impl.OrderDefaultService;
import user.repo.UserRepo;
import user.repo.impl.UserCollectionRepo;
import user.service.UserService;
import user.service.impl.UserDefaultService;

public class Demo {
    private UserRepo userRepo = new UserCollectionRepo();
    private CountryRepo countryRepo = new CountryCollectionRepo();
    private CityRepo cityRepo = new CityCollectionRepo();
    private OrderRepo orderRepo = new OrderCollectionRepo();


    private UserService userService = new UserDefaultService(userRepo, orderRepo);
    private CountryService markService = new CountryDefaultService(countryRepo, orderRepo);
    private CityService modelService = new CityDefaultService(cityRepo, orderRepo);
    private OrderService orderService = new OrderDefaultService(orderRepo);

    public static void main(String[] args) {

    }
}
