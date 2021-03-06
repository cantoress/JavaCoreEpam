package country.dto;

import country.domain.CountryDiscriminator;

public class ColdCountryDto extends CountryDto {
    private boolean hasPolarNights;
    private int telephoneCode;

    @Override
    protected void initDiscriminator() {
        countryDiscriminator = CountryDiscriminator.COLD;
    }

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

    @Override
    public String toString() {
        return super.toString() +
                "hasPolarNights=" + hasPolarNights +
                ", telephoneCode=" + telephoneCode +
                '}';
    }
}
