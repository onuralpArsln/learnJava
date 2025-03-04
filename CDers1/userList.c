#include <stdio.h>

int main()
{
    int n;

    // Dizinin boyutunu kullanıcıdan al
    printf("Dizinin boyutunu girin: ");
    scanf("%d", &n);

    // Dinamik olarak dizi oluştur
    int dizi[n];

    // Dizinin elemanlarını kullanıcıdan al
    for (int i = 0; i < n; i++)
    {
        printf("Dizinin %d. elemanını girin: ", i + 1);
        scanf("%d", &dizi[i]);
    }

    // Dizinin elemanlarını yazdır
    printf("Dizi elemanları: ");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", dizi[i]);
    }
    printf("\n");

    // Elemanlara erişim ve yazdırma
    for (int i = 0; i < n; i++)
    {
        printf("Sayilar[%d] = %d\n", i, dizi[i]);
    }

    int toplam = 0;
    // Dizi elemanlarının toplamını bulma
    for (int i = 0; i < n; i++)
    {
        toplam += dizi[i];
    }

    printf("Dizi elemanlarının toplamı: %d\n", toplam);

    return 0;
}
