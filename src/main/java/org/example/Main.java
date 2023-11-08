package org.example;

import java.util.Arrays;

public class Main {
    public static final int[] testArray1 = new int[]{14, 17, 18, 3, 8, 1, 18, 11, 13, 20};
    public static final int[] testArray2 = new int[]{2, 12, 22, 32, 42, 52, 62, 72, 82, 92};

    public static void main(String[] args) {
        int[] testArray3 = new int[20];
        System.arraycopy(testArray1, 0, testArray3, 0, 10);
        System.arraycopy(testArray1, 0, testArray3, 10, 10);

        testInputArray(
                testArray1,
                new HashMap<>(10, (k) -> k)
        );

//        testInputArray(
//                testArray2,
//                new HashMap<>(10, (k) -> k, (k) -> (int) (Math.floor(Math.sqrt(k))*2))
//        );

        HashMap<Integer> combiningBothExample = new HashMap<>(20, (k) -> k, (k) -> (7 - (k % 7)));
        for (int item : testArray2) {
            combiningBothExample.add(item, item);
            System.out.println(combiningBothExample);
        }
        for (int item : testArray1) {
            combiningBothExample.add(item, item);
            System.out.println(combiningBothExample);
        }
    }

    public static void testInputArray(int[] inputArray, HashMap<Integer> hashMap) {
        System.out.printf("Testing array %s\n", Arrays.toString(inputArray));
        for (int input: inputArray) {
            hashMap.add(input, input);
            System.out.println(hashMap);
        }
        System.out.println("Tested array.\n\n");
    }
}