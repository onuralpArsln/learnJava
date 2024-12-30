public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid; // Hedef bulundu
            } else if (arr[mid] < target) {
                low = mid + 1; // Sağ tarafa geç
            } else {
                high = mid - 1; // Sol tarafa geç
            }
        }
        return -1; // Hedef bulunamazsa
    }

    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Hedef bulunamazsa
        }

        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid; // Hedef bulundu
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, high); // Sağ tarafa geç
        } else {
            return binarySearchRecursive(arr, target, low, mid - 1); // Sol tarafa geç
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11 };
        int target = 7;
        int result = binarySearch(arr, target);
        System.out.println(result); // 3
        int result2 = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println(result2); // 3
    }
}
