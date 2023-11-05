package org.example;

import java.util.Arrays;

public class Main {
    public static final int[] testArray1 = new int[]{14, 7, 18, 3, 8, 2, 18, 11, 13, 20};
    public static final int[] testArray2 = new int[]{2, 12, 22, 32, 42, 52, 62, 72, 82, 92};

    public static void main(String[] args) {
        testInputArray(
                testArray1,
                new HashMap<>(10, (k) -> k)
        );

        testInputArray(
                testArray2,
                new HashMap<>(10, (k) -> (int) (Math.floor(Math.sqrt(k))*2))
        );

        testInputArray(
                testArray1,
                new HashMap<>(10, (k) -> (7 - (k % 7)))
        );
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