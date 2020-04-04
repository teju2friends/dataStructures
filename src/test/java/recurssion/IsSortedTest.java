package recurssion;

import org.junit.Assert;
import org.junit.Test;

public class IsSortedTest {

    @Test
    public void isSorted() {
        assertIsSorted(false, null);

        assertIsSorted(true, new int[0]);

        assertIsSorted(true, -1);
        assertIsSorted(true, 0);
        assertIsSorted(true, 1);

        assertIsSorted(true, 0, 1);
        assertIsSorted(true, 0, 1, 2);

        assertIsSorted(false, 1, 0);
        assertIsSorted(false, 1, 0, 6);
    }

    private void assertIsSorted(boolean expected, int... array) {
        boolean check = IsSorted.checkRecursively(array);
        Assert.assertEquals(expected, check);
    }
}














