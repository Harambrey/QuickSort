package src;


public class QuickSortOptimized {

    public static void quickSort(int[] arr, int low, int high) {
        int n = high - low + 1;
        if (n <= 3) {
            manualSort(arr, low, high);
        } else {
            double a = calculatePivot(arr, low, high);
            int q = partition(arr, low, high, a);
            if (q > low) {
                quickSort(arr, low, q - 1);
            }
            if (q < high) {
                quickSort(arr, q + 1, high);
            }

        }

    }

    private static void manualSort(int[] arr, int low, int high) {
        int n = high - low + 1;
        if (n <= 1) {
            return;
        }

        if (n == 2) {
            if (arr[low] > arr[high]) {
                swap(arr, low, high);
            }
        }

        if (n == 3) {
            if (arr[low] > arr[high-1]) {
                swap(arr, low, high-1);
            }
            if (arr[low] > arr[high]) {
                swap(arr, low, high);
            }
            if (arr[high - 1] > arr[high]) {
                swap(arr, high - 1, high);
            }
        }

    }

    private static double calculatePivot(int[] arr, int low, int high) {

        int half = (low + high) / 2;
        int maxLP = arr[low];
        int minLP = arr[low];
        int maxRP = arr[half];
        int minRP = arr[half];

        for (int i = low + 1; i < half; i++) {
            if (arr[i] > maxLP) {
                maxLP = arr[i];
            }
            if (arr[i] < minLP) {
                minLP = arr[i];
            }
        }

        double averageLP = (maxLP + minLP) / 2.0;

        for (int i = half; i <= high; i++) {
            if (arr[i] > maxRP) {
                maxRP = arr[i];
            }
            if (arr[i] < minRP) {
                minRP = arr[i];
            }
        }

        double averageRP = (maxRP + minRP) / 2.0;

        return (averageLP + averageRP) / 2;

    }

    private static int partition(int arr[], int low, int high, double pivot) {
        int i = low , j = high;

        while(true) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if (i >= j) {
                return j ;
            }
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = { 88, 77, 66, 55, 44, 33, 22, 11 };
        int low = 0;
        int high = arr.length-1;
        printArray(arr);
        quickSort(arr, low, high);
        printArray(arr);

    }

}
