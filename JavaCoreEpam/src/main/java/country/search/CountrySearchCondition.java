package country.search;

import common.business.search.BaseSearchCondition;
import country.domain.CountryDiscriminator;

public class CountrySearchCondition extends BaseSearchCondition<Long> {

    private String name;
    private String language;

    public boolean searchByName() {
        return (name != null) && (name.equals(""));
    }

    public boolean searchByLanguage() {
        return (language != null) && (language.equals(""));
    }

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

    private CountryDiscriminator countryDiscriminator;

    public CountryDiscriminator getCountryDiscriminator() {
        return countryDiscriminator;
    }

    public void setCountryDiscriminator(CountryDiscriminator countryDiscriminator) {
        this.countryDiscriminator = countryDiscriminator;
    }
}
