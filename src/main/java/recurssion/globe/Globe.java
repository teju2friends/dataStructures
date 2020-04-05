package recurssion.globe;

import java.util.ArrayList;
import java.util.List;


public class Globe {
    private List<Continent> continents = new ArrayList<>();

    private Site[][] sites;
    private int rows;
    private int cols;

    public Globe(Site[][] sites) {
        this.sites = sites;

        if (null != sites) {
            rows = sites.length;
        }

        if (rows > 0) {
            cols = sites[0].length;
        }

        initContinents();
    }

    public Globe(int[][] sitesData) {
        this(Site.toSite(sitesData));
    }

    private void initContinents() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Continent continent = new Continent(new ArrayList<>());

                processContinent(row, col, continent);

                if (continent.getTotalNumberOfCountries() > 0)
                    addContinents(continent);
            }
        }
    }

    private int processContinent(int row, int col, Continent continent) {
        if (isProcessed(row, col)) // O(1)
            return 0;

        Country country = new Country(row, col);
        continent.addCountry(country);

        sites[row][col] = Site.WATER;
        return 1 // Center
                + processContinent(row - 1, col - 1, continent) // NW
                + processContinent(row - 1, col, continent) // N
                + processContinent(row - 1, col + 1, continent) // NE
                + processContinent(row, col - 1, continent) // W
                + processContinent(row, col + 1, continent) // E
                + processContinent(row + 1, col - 1, continent) // SW
                + processContinent(row + 1, col, continent) // S
                + processContinent(row + 1, col + 1, continent);
    }

    private boolean isProcessed(int row, int col) {
        return !inRange(row, col) || sites[row][col] == Site.WATER;
    }

    private boolean inRange(int row, int col) {
        return row >= 0 && row < this.rows
                && col >= 0 && col < this.cols;
    }

    private void addContinents(Continent continent) {
        continents.add(continent);
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public Continent getLargestContinent() {
        Continent largestContinent = null;
        int maxSize = 0;

        if (continents.size() > 0) {
            for (Continent continent : continents) {
                int size = continent.getTotalNumberOfCountries();
                if (size > maxSize) {
                    maxSize = size;
                    largestContinent = continent;
                }
            }
        }
        return largestContinent;
    }
}
