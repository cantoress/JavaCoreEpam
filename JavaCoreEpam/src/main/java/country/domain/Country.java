package country.domain;

import common.business.domain.BaseDomain;

public abstract class Country extends BaseDomain<Long> {

    protected String name;
    protected String language;
    protected CountryDiscriminator countryDiscriminator;

    public Country() {
        initDiscriminator();
    }

    protected abstract void initDiscriminator();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public CountryDiscriminator getCountryDiscriminator() {
        return countryDiscriminator;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", countryDiscriminator=" + countryDiscriminator +
                ", id=" + id +
                '}';
    }
}
