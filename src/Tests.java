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

        int[] bestCase25 = new int[]{374, 819, 301, 498, 988, 357, 744, 237, 697, 720, 904, 625, 677, 668, 757, 725, 779, 702, 668 ,760, 770, 697, 743, 681, 708};
        int[] bestCase50 = new int[]{305, 528, 647, 628, 269, 367, 297, 490, 667 ,626, 467, 237 ,478, 570, 431, 640, 344, 285, 486, 251, 664, 436, 458, 548, 751, 737, 960, 701, 799, 729, 922, 899, 910, 863, 776, 717, 918, 683, 868, 890, 980, 670, 897, 805, 786, 971, 721, 831, 669, 988};
        int[] bestCase100 = new int[]{305, 528, 647, 628, 269, 367, 297, 490, 626, 467, 478, 570, 431, 640, 344, 285, 486, 251, 664, 436, 458, 548, 627, 629, 238, 593, 465, 373, 606, 354, 539, 289, 399, 252, 248, 250, 569, 514, 241, 432, 588, 347, 453, 608, 507, 350, 461, 520, 237, 667, 672, 960, 701, 799, 729, 922, 899, 910, 863, 776, 717, 918, 683, 868, 890, 980, 670, 897, 805, 786, 971, 721, 831, 684, 680, 682, 946, 673, 864, 779, 885, 939, 782, 893, 952, 788, 845, 787, 781, 904, 817, 882, 953, 720, 764, 820, 730, 839, 669, 988};

        long sumClassic = 0;
        for (int i = 0; i < 100000; i++) {

            //int[] arr = randomCase(100);
            //int[] arr = worstCase(100);
            int[] arr = bestCase100.clone();

            long startTime = System.nanoTime();
            QuickSortClassic.quickSort(arr);
            long endTime = System.nanoTime();
            long timeTaken = endTime - startTime;
            sumClassic += timeTaken;
        }

        System.out.println("Classic QuickSort: " + sumClassic / 100000);

        long sumOptimized = 0;
        for (int i = 0; i < 100000; i++) {

            //int[] arr = randomCase(100);
            //int[] arr = worstCase(100);
            int[] arr = bestCase100.clone();

            long startTime = System.nanoTime();
            QuickSortOptimized.quickSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            long timeTaken = endTime - startTime;
            sumOptimized += timeTaken;
        }

        System.out.println("Optimized QuickSort: " + sumOptimized / 100000);




    }

    private static int[] randomCase(int n) {
        int[] array = new int[n];
        fillRandom(array);
        return array;
    }

    private static int[] worstCase(int n) {
        int[] array = new int[n];
        fillRandom(array);
        Arrays.sort(array);
        return array;
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
