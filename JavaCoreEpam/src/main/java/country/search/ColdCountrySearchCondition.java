package country.search;

public class ColdCountrySearchCondition extends CountrySearchCondition {
    private boolean hasPolarNights;
    private int telephoneCode;

    public boolean isHasPolarNights() {
        return hasPolarNights;
    }

    public void setHasPolarNights(boolean hasPolarNights) {
        this.hasPolarNights = hasPolarNights;
    }

    public int getTelephoneCode() {
        return telephoneCode;
    }

    public void setTelephoneCode(int telephoneCode) {
        this.telephoneCode = telephoneCode;
    }

    public boolean searchByHasPolarNights() {
        return (hasPolarNights);
    }

    public boolean searchByTelephoneCode() {
        return (telephoneCode != 0);
    }
}
