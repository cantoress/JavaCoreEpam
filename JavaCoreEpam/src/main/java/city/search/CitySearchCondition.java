package city.search;

import common.business.search.BaseSearchCondition;

public class CitySearchCondition extends BaseSearchCondition<Long> {

    private String name;
    private int population;

    public boolean searchByName() {
        return (name != null) && (name.equals(""));
    }

    public boolean searchByPopulation(){
        return (population!=0);
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
}
