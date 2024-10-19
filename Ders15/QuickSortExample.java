import java.util.Arrays;

public class QuickSortExample {

    // QuickSort algoritması
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // sona kalınca durması için
            // Diziyi pivot noktasına göre ikiye ayır (partition işlemi)
            // Sol taraftan (ilk elemandan) gelirken pivot değerinden büyük elemanı bul
            // Sağ taraftan (son elemandan) gelirken pivot değerinden küçük elemanı bul ve
            // yerlerini değiştir

            // "high" pivot elemanının indexi (sondaki eleman pivot olarak seçiliyor)
            // "low" başlangıç elemanının indexi
            int pi = partition(arr, low, high); // Diziyi böl ve pivotu bul

            // Pivotun sol ve sağ tarafındaki elemanları recursive olarak sırala
            quickSort(arr, low, pi - 1); // Sol tarafı sırala
            quickSort(arr, pi + 1, high); // Sağ tarafı sırala
        }
    }

    // Partition işlemi: Pivot seçilir ve elemanlar yer değiştirir
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot elemanı en son eleman olarak seç
        int i = (low - 1); // Daha küçük elemanlar için index (başlangıç elemanının bir önceki indexi)

        // Pivottan küçük olanları sola, büyük olanları sağa yerleştir
        for (int j = low; j < high; j++) {
            // Eğer mevcut eleman pivot değerinden küçükse
            if (arr[j] < pivot) {
                i++; // Sol taraftaki elemanlar için indexi arttır

                // arr[i] ve arr[j]'yi yer değiştir
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Pivotu doğru konuma yerleştir (arr[i+1] ve arr[high]'yi yer değiştir)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Yeni pivotun yerini döndür
    }

    // Ana fonksiyon
    public static void main(String[] args) {
        int[] arr = { 10, 80, 30, 90, 40, 50, 70 }; // Sıralanacak dizi
        System.out.println("Orijinal Dizi: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1); // QuickSort algoritmasını çağır

        System.out.println("Sıralanmış Dizi: " + Arrays.toString(arr)); // Sıralı dizi çıktısı
    }
}
