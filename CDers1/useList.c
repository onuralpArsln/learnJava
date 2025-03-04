#include <stdio.h>

int main()
{
    int sayilar[5] = {1, 2, 3, 4, 5};
    // Elemanlara erişim ve yazdırma
    for (int i = 0; i < 5; i++)
    {
        printf("Sayilar[%d] = %d\n", i, sayilar[i]);
    }
    int toplam = 0;
    // Dizi elemanlarının toplamını bulma
    for (int i = 0; i < 5; i++)
    {
        toplam += sayilar[i];
    }
    printf("Dizi elemanlarının toplamı: %d\n", toplam);
    return 0;
}
