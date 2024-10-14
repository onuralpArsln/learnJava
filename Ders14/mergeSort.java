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

    // burasının çalışma mantığı sağ ve soldaki kısımların kendi içinde sıralı
    // olduğunu düşünmesidir.
    // sen kalan tek sağ ve sol sayıları mesela 2 ve 5 verince bunlar kendi içinde
    // sıralı bunları 2 5 diye yazar
    // öbür taraftan gelecek 4 ve 6 da 4 6 olarak sırlanır. Sonra liste 2 5 4 6 olur
    // sağ sol sıralı bunları ortada sıralayıp
    // 2 4 5 6 yapar
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sol ve sağ alt dizilerin boyutları
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Geçici diziler oluşturma
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Verileri geçici dizilere kopyalama
        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];

        // Geçici dizileri sıralı şekilde ana diziye birleştirme
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Kalan elemanları ekleme
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSortApplied(int[] arr, int left, int right) {
        if (left < right) {
            // Orta noktayı bul
            int mid = (left + right) / 2;

            // Sol yarıyı böl ve sırala
            mergeSortApplied(arr, left, mid);

            // Sağ yarıyı böl ve sırala
            mergeSortApplied(arr, mid + 1, right);

            // İki yarıyı birleştir
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        arraySplitter(arr, 0, arr.length - 1);

        int[] arr2 = { 0, 51, 23, 37, 14, 5, 66, 17, 283, 39 };

        mergeSortApplied(arr2, 0, arr2.length - 1);
        for (int i : arr2) {
            System.out.println(i);

        }
    }

}
