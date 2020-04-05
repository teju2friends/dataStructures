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

    private void processContinent(int row, int col, Continent continent) {
        if (isProcessed(row, col))
            return;

        continent.addCountry(new Country(row, col));

        sites[row][col] = Site.WATER; // Dont count this country again

        int[][] coordinateDelta = new int[][]{
                {-1, 0}, // N
                {-1, -1}, // NW
                {-1, 1}, // NE

                {0, -1}, // W
                {0, 1}, // E

                {1, 0},// S
                {1, -1}, // SW
                {1, 1} // SE
        };

        for (int[] delta : coordinateDelta) {
            processContinent(row + delta[0], col + delta[1], continent);
        }
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
