package src;

import java.util.Random;
import src.QuickSortClassic;
import src.QuickSortOptimized;

public class Tests {
    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = new int[100];
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000); // storing random integers in an array
        }

        

    }

}
