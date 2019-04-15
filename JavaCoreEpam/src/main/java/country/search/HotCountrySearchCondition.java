package country.search;

public class HotCountrySearchCondition extends CountrySearchCondition {
    private double averageTemperature;
    private int hottestMonth;

    public int getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(int hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public boolean searchByAverageTemperature() {
        return (averageTemperature != 0.0);
    }

    public boolean searchByHottestMonth() {
        return (hottestMonth != 0);
    }
}
