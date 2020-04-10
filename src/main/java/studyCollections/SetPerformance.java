package studyCollections;

import java.util.*;
import java.util.stream.Stream;

public class SetPerformance {

    public static void main(String[] args) {

        List<List<PerformanceMeasure>> data = new ArrayList<>();
        Integer[] inputRange = {
                1,
                100,
                1000,
                10_000,
                100_000,
                1_000_000,
                10_000_000
        };

        List<PerformanceMeasure> hashSet = measureListPerformance(new HashSet<>(), inputRange);
        List<PerformanceMeasure> linkedHashSet = measureListPerformance(new LinkedHashSet<>(), inputRange);
        List<PerformanceMeasure> treeSet = measureListPerformance(new TreeSet<>(), inputRange);

        data.add(hashSet);
        data.add(linkedHashSet);
        data.add(treeSet);

//        data.forEach(pl->pl.forEach(p-> System.out.println(p.toTab())));

        for (int i = 0; i < inputRange.length; i++) {
            System.out.println(data.get(0).get(i).toCsv());
            System.out.println(data.get(1).get(i).toCsv());
            System.out.println(data.get(2).get(i).toCsv());
            System.out.println();
        }

    }

    private static List<PerformanceMeasure> measureListPerformance(Set<Integer> myList, Integer[] inputRange) {
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
//                            System.err.println(performanceMeasure.toCsv());
                        }
                );
        return performanceMeasures;
    }

    private static long measureReverseDelete(Set<Integer> myList, int n) {
        long start = System.nanoTime();
        // Reverse Delete
        for (int i = n - 1; i >= 0; i--) {
            myList.remove(i);
        }
        long endOfReverseDeleteTime = System.nanoTime();

        measureCreateTime(myList, n);
        return endOfReverseDeleteTime - start;
    }

    private static long measureDelete(Set<Integer> myList, int n) {
        long start = System.nanoTime();
        // Delete
        for (int i = 0; i < n; i++) {
            myList.remove(i);
        }
        long endOfDeleteTime = System.nanoTime();

        measureCreateTime(myList, n);
        return endOfDeleteTime - start;
    }

    private static long measureReverseRead(Set<Integer> myList, int n) {
        long start = System.nanoTime();
        // Reverse Read
        for (int i = n - 1; i >= 0; i--) {
            myList.contains(i);
        }
        long endOfReverseReadTime = System.nanoTime();
        return endOfReverseReadTime - start;
    }

    private static long measureReadTime(Set<Integer> myList, int n) {
        long start = System.nanoTime();

        // Read
        for (int i = 0; i < n; i++) {
            myList.contains(i);
        }
        long endOfReadTime = System.nanoTime();
        return endOfReadTime - start;
    }

    private static long measureCreateTime(Set<Integer> myList, int n) {
        long start = System.nanoTime();
        // Create
        for (int i = 0; i < n; i++) {
            myList.add(i);
        }
        long endCreateTime = System.nanoTime();
        return endCreateTime - start;
    }

}


