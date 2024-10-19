
import java.util.Arrays;

public class QuickSortExample {

    // QuickSort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the pivot element such that elements smaller than pivot are on the left,
            // and elements larger than pivot are on the right
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function that returns the partition index
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot element
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 80, 30, 90, 40, 50, 70 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
