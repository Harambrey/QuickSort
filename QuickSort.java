public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        int n = low - high + 1;
        if (n <= 3) {
            manualSort(arr, low, high);
        } else {

        }

    }

    private static void manualSort(int[] arr, int low, int high) {
        int n = low - high + 1;
        if (n <= 1) {
            return;
        }

        if (n == 2) {
            if (arr[low] > arr[high]) {
                swap(arr, low, high);
            }
        }

        if (n == 3) {
            if (arr[low] > arr[high]) {
                swap(arr, low, high-1);
            }
        }

        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        if (arr[high-1] > arr[high]) {
            swap(arr, high-1, high);
        }
    }

    private static void partition(int arr[],int low,int high,double pivot) {
        int i = low-1;
        int j = high+1;

       do {
        while (arr[i] < pivot) {
            i++;
        }

        while (arr[j] > pivot) {
            j--;
        }

        if (i >= j) {
            break;
        }

       } while(true);

       swap(arr, i, j);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
