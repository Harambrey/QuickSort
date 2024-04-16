package src;

import java.util.Random;
import src.QuickSortClassic;
import src.QuickSortOptimized;

public class Tests {
    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(31);

        int[] arr = new int[50];
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000); // storing random integers in an array
        }

        printArray(arr);

        QuickSortOptimized.quickSort(arr, 0, n-1);

        printArray(arr);

    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

}
