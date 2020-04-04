package recurssion;

import java.util.ArrayList;
import java.util.List;

enum Site {
    WATER(0),
    LAND(1);

    int value;

    Site(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}

public class IslandSize {
    public static int processInvoke = 0;

    public static List<Continent> getAllContinents(int[][] globe) {
        List<Continent> continents = new ArrayList<>();
        if (null == globe) {
            return continents;
        }

        for (int row = 0; row < globe.length; row++) {
            for (int col = 0; col < globe[0].length; col++) {
                Continent continent = new Continent(new ArrayList<>());

                process(globe, row, col, continent);

                if (continent.getTotalNumberOfCountries() > 0)
                    continents.add(continent);
            }
        }

        return continents;
    }

    private static int process(int[][] globe, int row, int col, Continent continent) {
        if (isProcessed(globe, row, col))
            return 0;

        processInvoke++;

        Country country = new Country(row, col);
        continent.addCountry(country);

        globe[row][col] = Site.WATER.getValue();
        return 1 // Center
                + process(globe, row - 1, col - 1, continent) // NW
                + process(globe, row - 1, col, continent) // N
                + process(globe, row - 1, col + 1, continent) // NE
                + process(globe, row, col - 1, continent) // W
                + process(globe, row, col + 1, continent) // E
                + process(globe, row + 1, col - 1, continent) // SW
                + process(globe, row + 1, col, continent) // S
                + process(globe, row + 1, col + 1, continent);
    }

    private static boolean isProcessed(int[][] globe, int row, int col) {
        return outOfRange(globe, row, col) || globe[row][col] == Site.WATER.getValue();
    }

    private static boolean outOfRange(int[][] globe, int row, int col) {
        return null == globe
                || row < 0
                || col < 0
                || row > (globe.length - 1)
                || col > (globe[0].length - 1);
    }
}

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

class Country {
    private int row;
    private int col;

    public Country(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "[" + row + ", " + col + ']';
    }
}
