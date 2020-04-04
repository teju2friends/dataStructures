package recurssion;

public class IsSorted {

    public static boolean checkRecursively(int... array) {
        return checkRecursively(0, array);
    }

    private static boolean checkRecursively(int sratrIndex, int... array) {
        if (null == array) {
            return false;
        }

        if (sratrIndex >= array.length - 1) {
            return true;
        }

        return array[sratrIndex] < array[sratrIndex + 1] && checkRecursively(sratrIndex + 1, array);
    }
}
