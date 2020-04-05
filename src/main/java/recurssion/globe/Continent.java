package recurssion.globe;

import java.util.List;

class Continent {
    private List<Country> pointers;
    private int totalNumberOfCountries;

    public Continent(List<Country> pointers) {
        this.pointers = pointers;
    }

    public int getTotalNumberOfCountries() {
        return totalNumberOfCountries;
    }

    public void addCountry(Country country) {
        pointers.add(country);
        totalNumberOfCountries = pointers.size();
    }

    @Override
    public String toString() {
        return totalNumberOfCountries + " -> " + pointers.toString();
    }
}
