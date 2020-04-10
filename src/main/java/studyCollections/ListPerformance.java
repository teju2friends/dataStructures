package studyCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class ListPerformance {

    public static void main(String[] args) {

        List<List<PerformanceMeasure>> data = new ArrayList<>();
        Integer[] inputRange = {
                1,
                100,
                1000,
                10_000,
                100_000,
//                1_000_000,
//                10_000_000
        };

        List<PerformanceMeasure> arrayListPerformance = measureListPerformance(new ArrayList<>(), inputRange);
        List<PerformanceMeasure> linkedListPerformance = measureListPerformance(new LinkedList<>(), inputRange);
        List<PerformanceMeasure> vectorPerformance = measureListPerformance(new Vector<>(), inputRange);

        data.add(arrayListPerformance);
        data.add(linkedListPerformance);
        data.add(vectorPerformance);

//        data.forEach(pl->pl.forEach(p-> System.out.println(p.toTab())));

        for (int i = 0; i < inputRange.length; i++) {
            System.out.println(data.get(0).get(i).toCsv());
            System.out.println(data.get(1).get(i).toCsv());
            System.out.println(data.get(2).get(i).toCsv());
            System.out.println();
        }


    }

    private static List<PerformanceMeasure> measureListPerformance(List<Integer> myList, Integer[] inputRange) {
        List<PerformanceMeasure> performanceMeasures = new ArrayList<>();
        Stream
                .of(inputRange)
                .forEach(n -> {
                            PerformanceMeasure performanceMeasure = new PerformanceMeasure(
                                    myList.getClass().getSimpleName(),
                                    n,
                                    measureCreateTime(myList, n),
                                    measureReadTime(myList, n),
                                    measureReverseRead(myList, n),
                                    measureDelete(myList, n),
                                    measureReverseDelete(myList, n)
                            );
                            performanceMeasures.add(performanceMeasure);

                        }
                );
        return performanceMeasures;
    }

    private static long measureReverseDelete(List<Integer> myList, int n) {
        long start = System.nanoTime();
        // Reverse Delete
        for (int i = n - 1; i >= 0; i--) {
            myList.remove(i);
        }
        long endOfReverseDeleteTime = System.nanoTime();

        measureCreateTime(myList, n);
        return endOfReverseDeleteTime - start;
    }

    private static long measureDelete(List<Integer> myList, int n) {
        long start = System.nanoTime();
        // Delete
        for (int i = 0; i < n; i++) {
            myList.remove(0);
        }
        long endOfDeleteTime = System.nanoTime();

        measureCreateTime(myList, n);
        return endOfDeleteTime - start;
    }

    private static long measureReverseRead(List<Integer> myList, int n) {
        long start = System.nanoTime();
        // Reverse Read
        for (int i = n - 1; i >= 0; i--) {
            myList.get(i);
        }
        long endOfReverseReadTime = System.nanoTime();
        return endOfReverseReadTime - start;
    }

    private static long measureReadTime(List<Integer> myList, int n) {
        long start = System.nanoTime();

        // Read
        for (int i = 0; i < n; i++) {
            myList.get(i);
        }
        long endOfReadTime = System.nanoTime();
        return endOfReadTime - start;
    }

    private static long measureCreateTime(List<Integer> myList, int n) {
        long start = System.nanoTime();
        // Create
        for (int i = 0; i < n; i++) {
            myList.add(i);
        }
        long endCreateTime = System.nanoTime();
        return endCreateTime - start;
    }

}


