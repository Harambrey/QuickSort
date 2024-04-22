package src;

// Class QuickSortOptimized contains methods to perform an optimized version of the Quick Sort algorithm.
public class QuickSortOptimized {

    // The quickSort method is the entry point for the sorting algorithm.
    // It takes an array and the low and high indices as parameters.
    public static void quickSort(int[] arr, int low, int high) {
        // Calculate the number of elements in the range to be sorted.
        int n = high - low + 1;

        // If the range is less than or equal to 3, use the manualSort method.
        if (n <= 3) {
            manualSort(arr, low, high);
        } else {
            // Otherwise, calculate a pivot using the calculatePivot method.
            double a = calculatePivot(arr, low, high);
            // Partition the array around the pivot and get the partition index.
            int q = partition(arr, low, high, a);

            // Recursively apply quickSort to the sub-arrays.
            quickSort(arr, low, q);
            quickSort(arr, q + 1, high);
        }
    }

    // The manualSort method sorts small arrays manually.
    private static void manualSort(int[] arr, int low, int high) {
        // Determine the number of elements to sort.
        int n = high - low + 1;
        // If there's only one element, no sorting is needed.
        if (n <= 1) {
            return;
        }

        // If there are two elements, swap them if they are out of order.
        if (n == 2) {
            if (arr[low] > arr[high]) {
                swap(arr, low, high);
            }
        }

        // If there are three elements, sort them manually.
        if (n == 3) {
            if (arr[low] > arr[high-1]) {
                swap(arr, low, high-1);
            }
            
        }

        if (arr[low] > arr[high]) {
                swap(arr, low, high);
            }
            if (arr[high - 1] > arr[high]) {
                swap(arr, high - 1, high);
            }
    }

    // The calculatePivot method calculates the pivot for partitioning.
    private static double calculatePivot(int[] arr, int low, int high) {
        // Find the middle index of the array.
        int half = (low + high) / 2;
        // Initialize variables to find the max and min of the left and right parts.
        int maxLP = arr[low];
        int minLP = arr[low];
        int maxRP = arr[half];
        int minRP = arr[half];

        // Find the max and min of the left part.
        for (int i = low + 1; i < half; i++) {
            if (arr[i] > maxLP) {
                maxLP = arr[i];
            }
            if (arr[i] < minLP) {
                minLP = arr[i];
            }
        }

        // Calculate the average of the max and min of the left part.
        double averageLP = (maxLP + minLP) / 2.0;

        // Find the max and min of the right part.
        for (int i = half; i <= high; i++) {
            if (arr[i] > maxRP) {
                maxRP = arr[i];
            }
            if (arr[i] < minRP) {
                minRP = arr[i];
            }
        }

        // Calculate the average of the max and min of the right part.
        double averageRP = (maxRP + minRP) / 2.0;

        // Return the average of the two averages as the pivot.
        return (averageLP + averageRP) / 2;
    }

    // The partition method rearranges the elements around the pivot.
    private static int partition(int arr[], int low, int high, double pivot) {
        // Initialize pointers for the low and high ends of the array.
        int i = low , j = high;

        // Loop to move elements around the pivot.
        while(true) {
            //System.out.println(pivot);
            //System.out.println(arr[i]);
            // Increment i until an element greater than the pivot is found.
            while (arr[i] <= pivot) {
                i++;
            }
            // Decrement j until an element less than the pivot is found.
            while (arr[j] > pivot) {
                j--;
            }

            // If the pointers have crossed, return the partition index.
            if (i >= j) {
                return j ;
            }
            // Swap the elements at i and j.
            swap(arr, i, j);
        }
    }

    // The swap method exchanges the elements at two indices in the array.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // The printArray method prints the elements of the array.
    private static void printArray(int[] arr) {
        System.out.print("[ ");
        // Loop through the array and print each element.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // The main method demonstrates the use of the quickSort method.
    public static void main(String[] args) {
        // Initialize an array with unsorted elements.
        int[] arr = { 88, 77, 66, 55, 44, 33, 22, 11 };
        // Define the low and high indices for the entire array.
        int low = 0;
        int high = arr.length-1;
        // Print the array before sorting.
        printArray(arr);
        // Sort the array using the quickSort method.
        quickSort(arr, low, high);
        // Print the array after sorting.
        printArray(arr);
    }
}
