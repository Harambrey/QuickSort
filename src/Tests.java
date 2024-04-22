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
        

        int[] arr = new int[25];
        int n = arr.length;
        fillRandom(arr);
        //Arrays.sort(arr);
        //reverseArray(arr);
        int[] bestCase25 = new int[]{160, 271, 342, 331, 125, 321, 142, 191, 156, 351,252, 320, 78, 106, 118, 69, 74, 86, 77, 101, 123, 98, 100, 111, 94};
        int[] bestCase50 = new int[]{326, 178, 149, 249, 132, 338, 224, 235, 280, 320, 321, 125, 303, 239, 193, 309, 125, 330, 183, 351, 276, 151, 206, 347, 71, 122, 111, 104, 70, 94, 113, 83, 97, 121, 103, 84, 98, 101, 69, 105, 120, 92, 107, 123, 108, 99, 88, 116, 115, 96};
        int[] bestCase100 = new int[]{267, 289, 150, 172, 286, 310, 345, 200, 155, 315, 210, 309, 307, 253, 233, 254, 296, 173, 202, 197, 275, 252, 336, 225, 331, 133, 247, 187, 342, 228, 231, 295, 125 ,169, 218, 265, 304, 297, 351 ,313, 220, 147, 237, 294, 255, 152, 166, 258, 328, 219, 250, 116, 71, 100, 72, 89, 115, 109, 107, 117, 95, 111, 80, 112, 102, 84, 70, 82, 104, 108, 113, 122, 92, 120, 97, 88, 81, 105, 78, 91, 87, 118, 114, 69, 106, 86, 74, 101, 76, 83, 94, 123, 77, 75, 79, 103, 73, 110, 93, 99};

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
        QuickSortClassic.quickSort(arr2);
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

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000); // storing random integers in an array
        }
    }

    private static void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
