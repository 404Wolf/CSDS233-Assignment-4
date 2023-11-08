package org.main;

import java.util.Arrays;

public class Main {
    public static final int[] testArray1 = new int[]{14, 17, 18, 3, 8, 1, 18, 11, 13, 20};
    public static final int[] testArray2 = new int[]{2, 12, 22, 32, 42, 52, 62, 72, 82, 92};

    public static void main(String[] args) {
        int index;

        try {
            System.out.println("Inserting elements of ");
            System.out.println(Arrays.toString(testArray1) + " into new hashmap...");
            HashMap<Integer> onlyArray1 = new HashMap<>(10, (k) -> k);
            for (int item : testArray2) {
                index = onlyArray1.add(item, item);
                System.out.println(onlyArray1);
                System.out.println("Inserted at index " + index);
            }

            System.out.println("Inserting elements of ");
            System.out.println(Arrays.toString(testArray2) + " into new hashmap with a fancy hash function...");
            HashMap<Integer> onlyArray2 = new HashMap<>(10, (k) -> (int) Math.cosh((double) (k + 2) / 5));
            for (int item : testArray2) {
                index = onlyArray2.add(item, item);
                System.out.println(onlyArray2);
                System.out.println("Inserted at index " + index);
            }

            System.out.println("Combining the array");
            System.out.println(Arrays.toString(testArray1));
            System.out.println("With");
            System.out.println(Arrays.toString(testArray2) + "in a new hashmap...");

            HashMap<Integer> combiningBothExample = new HashMap<>(20, (k) -> k, (k) -> (7 - (k % 7)));
            for (int item : testArray2) {
                index = combiningBothExample.add(item, item);
                System.out.println(combiningBothExample);
                System.out.println("Inserted at index " + index);
            }
            for (int item : testArray1) {
                index = combiningBothExample.add(item, item);
                System.out.println(combiningBothExample);
                System.out.println("Inserted at index " + index);
            }
        }
        catch (HashMap.EndlessDoubleHashException e) {
            System.out.println("Double hashing failed, an infinite loop has been avoided. Exiting...");
        }
    }
}