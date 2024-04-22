package src;



public class QuickSortClassic {
    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        quickSortHelper(arr, low, high);
    }

    public static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex-1);
            quickSortHelper(arr, pivotIndex+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        
        int pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i + 1;
        
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
        int[] arr = {11, 77, 55,66 , 44, 33, 22, 88};
        int low = 0;
        int high = arr.length-1;
        printArray(arr);
        printArray(arr);
    }

}
