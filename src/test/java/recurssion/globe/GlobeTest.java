package recurssion.globe;

import org.junit.Assert;
import org.junit.Test;

public class GlobeTest {
    @Test
    public void assertSize() {
        assertLargestContinentSize(0, 0, null);
        assertLargestContinentSize(0, 0, new int[0][0]);
        assertLargestContinentSize(1, 1, new int[][]{
                {1}
        });
        assertLargestContinentSize(3, 5, new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 1},
        });

        assertLargestContinentSize(1, 9, new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        assertLargestContinentSize(1, 3, new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
        });
    }

    private void assertLargestContinentSize(
            int continentNumber,
            int largestContinentSize,
            int[][] sites
    ) {
        Globe globe = new Globe(sites);

        Assert.assertEquals(continentNumber, globe.getContinents().size());

        int totalNumberOfCountries = 0;

        Continent largestContinent = globe.getLargestContinent();
        if (null != largestContinent)
            totalNumberOfCountries = largestContinent.getTotalNumberOfCountries();

        Assert.assertEquals(largestContinentSize, totalNumberOfCountries);
    }
}
