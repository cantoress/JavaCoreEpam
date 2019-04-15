package city.domain;

import common.business.domain.BaseDomain;

public class City extends BaseDomain<Long> {
    protected Long countryId;
    protected String name;
    protected int population;
    protected boolean isCapital;

    public City() {
    }

    public City(Long countryId, String name, int population, boolean isCapital) {
        this.countryId = countryId;
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return "City{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", isCapital=" + isCapital +
                ", id=" + id +
                '}';
    }
}
