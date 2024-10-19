import java.util.Arrays;

public class QuickSortExampleStepByStep {

    // Adım adım QuickSort algoritması
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Diziyi pivot noktasına göre ayır (partition işlemi)
            int pi = partition(arr, low, high);

            // Dizi ve pivotun bulunduğu durumu yazdır
            System.out.println("Pivot: " + arr[pi] + " | Dizi: " + Arrays.toString(arr));

            // Pivotun sol ve sağ tarafındaki elemanları recursive olarak sırala
            quickSort(arr, low, pi - 1); // Sol tarafı sırala
            quickSort(arr, pi + 1, high); // Sağ tarafı sırala
        }
    }

    // Partition işlemi: Pivot seçilir ve elemanlar yer değiştirir
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot olarak en son eleman seçilir
        int i = (low - 1); // Küçük elemanların yerleşeceği index

        // Pivottan küçük olanları sola, büyük olanları sağa yerleştir
        for (int j = low; j < high; j++) {
            // Eğer mevcut eleman pivot değerinden küçükse
            if (arr[j] < pivot) {
                i++; // Sol taraftaki elemanlar için indexi arttır

                // arr[i] ve arr[j]'yi yer değiştir
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                // Elemanların yer değiştirme adımını yazdır
                System.out.println("Yer degistirildi: " + Arrays.toString(arr));
            }
        }

        // Pivotu doğru konuma yerleştir (arr[i+1] ve arr[high]'yi yer değiştir)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Pivotun yerleşimini yazdır
        System.out.println("Pivot degistirildi: " + Arrays.toString(arr));

        return i + 1; // Yeni pivotun yerini döndür
    }

    public static void main(String[] args) {
        int[] arr = { 10, 80, 30, 90, 40, 50, 70 }; // Sıralanacak dizi
        System.out.println("Orijinal Dizi: " + Arrays.toString(arr));

        // QuickSort algoritmasını çağır ve adım adım göster
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Siralanmiş Dizi: " + Arrays.toString(arr)); // Sıralı dizi çıktısı
    }
}
