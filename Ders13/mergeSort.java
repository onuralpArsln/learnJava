// merge sort arrayı iki parçaya böler
// sonra parçaları birleştirir 
//  bölme işlemi array başına bir eleman kalana kadar 
// devam eder 

public class mergeSort {

    // bölme işlemi nasıl gerçekleşiyor onu görelim
    public static void arraySplitter(int[] arr, int left, int right) {

        // left step array başı right sonu pozisyonu olarak başladı
        // left -> sıfır ve right -> 5 mesela (6 eleman için)
        // sol sağdan küçük olduğu sürece (sol 2 sağ 4) arada eleman vardır işlem
        // yapılır
        if (left < right) {
            // Print the current array segment
            System.out.print("Current Split: ");
            for (int i = left; i <= right; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            // Find the midpoint
            int mid = (left + right) / 2;

            // Recursively split the left half
            arraySplitter(arr, left, mid);

            // Recursively split the right half
            arraySplitter(arr, mid + 1, right);
        } else if (left == right) {
            // Print single element when it's reached
            System.out.println("Single Element: " + arr[left]);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2 };
        arraySplitter(arr, 0, arr.length - 1);
    }

}
