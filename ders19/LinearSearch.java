public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // hedef bulunursa, dizindeki indexi döner
            }
        }
        return -1; // hedef bulunmazsa, -1 döner
    }

    public static int linearSearchRecursive(int[] arr, int target, int index) {
        if (index >= arr.length) {
            return -1; // Dizinin sonuna gelindiğinde hedef bulunamamış demektir
        }
        if (arr[index] == target) {
            return index; // Hedef bulundu
        }
        return linearSearchRecursive(arr, target, index + 1); // Bir sonraki elemana geç
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10 };
        int target = 6;
        int result = linearSearch(arr, target);
        System.out.println(result); // 2
        int result2 = linearSearchRecursive(arr, target, 0);
        System.out.println(result2); // 2
    }
}
