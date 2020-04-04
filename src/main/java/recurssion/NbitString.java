package recurssion;

import java.util.ArrayList;
import java.util.List;

public class NbitString {

    public static void generate(int n) {
        List<String> results = new ArrayList<>();

        polulate(new int[n], 0, results);

        results.forEach(System.out::println);
        System.out.println("----------------");
    }

    private static void polulate(int[] tempArray, int start, List<String> results) {
        if (start >= tempArray.length) {
            String result = collect(tempArray);
            results.add(result);
            return;
        }

        tempArray[start] = 0;
        polulate(tempArray, start + 1, results);

        tempArray[start] = 1;
        polulate(tempArray, start + 1, results);
    }


    private static String collect(int[] array) {
        if (null == array) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i : array) {
            builder.append(i + "");
        }
        return builder.toString();
    }
}
