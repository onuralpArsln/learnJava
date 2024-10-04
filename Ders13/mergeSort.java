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
            // şuan neyi bölmeye çalışıyoruz ekrana yazalım
            System.out.print("Mevcut array: ");
            // left ve right arasındaki değerleri yazalım
            // (bu sadece görelim diye normalde gereksiz)
            for (int i = left; i <= right; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            // orta noktayı bulalım
            int mid = (left + right) / 2;

            // orta ve sol arasını bölelim
            arraySplitter(arr, left, mid);

            // orta ve sağ arasını bölelim
            arraySplitter(arr, mid + 1, right);
        } else if (left == right) {
            // elimizde tek eleman kalınca konu kapanır bölme durur
            System.out.println("sona kalan: " + arr[left]);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2 };
        arraySplitter(arr, 0, arr.length - 1);
    }

}
