package src;

import java.util.Random;
import src.QuickSortClassic;
import src.QuickSortOptimized;
import java.io.*;
import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        /*
         * the worst case is when the array is either already sorted or sorted in descending order, which
         * requires the worst case partitioning
         */

        int[] arr = new int[100];
        int n = arr.length;

        fillRandom(arr);
        Arrays.sort(arr);

        int[] arr1 = arr.clone();

        //optimized quicksort
        System.out.println("Proposed QuickSort");
        printArray(arr1);
        long startTime = System.nanoTime();
        QuickSortOptimized.quickSort(arr1, 0, n-1);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println(timeTaken + " nanoseconds");
        printArray(arr1);

        System.out.println();
        System.out.println("Classic QuickSort");

        int[] arr2 = arr.clone();

        //classic quicksort
        printArray(arr2);
        startTime = System.nanoTime();
        QuickSortClassic.quickSort(arr2, 0, n-1);
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println(timeTaken + " nanoseconds");
        printArray(arr2);
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    private static void fillRandom(int[] arr) {
        Random random = new Random();
        random.setSeed(31);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000); // storing random integers in an array
        }
    }

}
