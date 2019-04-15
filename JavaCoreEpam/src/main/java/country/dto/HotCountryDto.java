package country.dto;

import country.domain.CountryDiscriminator;

public class HotCountryDto extends CountryDto {
    private double averageTemperature;
    private int hottestMonth;


    @Override
    protected void initDiscriminator() {
        countryDiscriminator = CountryDiscriminator.HOT;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public int getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(int hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    @Override
    public String toString() {
        return super.toString() +
                "averageTemperature=" + averageTemperature +
                ", hottestMonth=" + hottestMonth +
                '}';
    }
}