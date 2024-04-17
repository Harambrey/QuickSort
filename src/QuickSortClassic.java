package src;



public class QuickSortClassic {
    public static void quickSort(int[] arr,int pi, int ri) {
        if (pi < ri) {
            int qt = partition(arr, pi, ri);
            quickSort(arr, pi, qt);
            quickSort(arr, qt+1, ri);
        }
    }

    public static int partition(int[] arr, int pi, int ri) {
        int pivot = arr[pi];
        int left = pi + 1;
        int right = ri;
    
        while (left <= right) {
            while (left <= ri && arr[left] < pivot) {
                left++;
            }
    
            while (right >= pi && arr[right] > pivot) {
                right--;
            }
    
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    
        swap(arr, pi, right);
        return right;
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
        quickSort(arr, low, high);
        printArray(arr);
    }

}
