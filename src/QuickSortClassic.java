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
        int xt = arr[pi];
        int it = pi-1;
        int jt = ri+1;
        while (true) {
            jt = jt-1;
            if (arr[jt] <= xt) {
                break;
            }
        }

        while (true) {
            it = it+1;
            if (arr[it] >= xt) {
                break;
            }
        }
        swap(arr, it, jt);
        return jt;
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
