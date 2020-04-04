package recurssion;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ContinentSizeTest {
    @Test
    public void assertSize() {
//        assertIslandSize(9, new int[][]{
//                {1, 1, 1},
//                {1, 1, 1},
//                {1, 1, 1}
//        });

        assertIslandSize(3, new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
        });

        System.err.println("------> "+IslandSize.processInvoke);

//        assertIslandSize(0, null);
//        assertIslandSize(0, new int[0][0]);
//        assertIslandSize(1, new int[][]{
//                {1}
//        });
//        assertIslandSize(5, new int[][]{
//                {1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 0},
//                {0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 1},
//                {0, 1, 0, 1, 1},
//        });
    }

    private void assertIslandSize(int expected, int[][] globe) {
        List<Continent> continents = IslandSize.getAllContinents(globe);

        continents.forEach(continent -> System.out.println(continent.toString()));

        int maxSize = getMaxSize(continents);
        Assert.assertEquals(expected, maxSize);
    }

    private int getMaxSize(List<Continent> continents) {
        int maxSize = 0;

        if (continents.size() > 0) {
            for (Continent continent : continents) {
                int size = continent.getTotalNumberOfCountries();
                if (size > maxSize)
                    maxSize = size;
            }
        }
        return maxSize;
    }

}
