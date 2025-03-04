#include <stdio.h>

int main()
{
    int sayi = 5;    
    float pi = 3.14; 
    char harf = 'A'; 

    printf("Sayi: %d\n", sayi); 
    printf("Pi: %.2f\n", pi);  
    printf("Harf: %c\n", harf); 

    return 0;
}

/*
%d: Tam sayı (int) yazdırmak için.
%.2f: Ondalık sayı (float) yazdırmak için, virgülden sonra 2 basamağa kadar.
%.3f: virgülden sonra 3 basamağa kadar.
%c: Karakter (char) yazdırmak için.
%o: Tam sayıyı sekizlik (octal) sistemde yazdırır.
%X: Tam sayıyı büyük harflerle onaltılık (hexadecimal) sistemde yazdırır.
*/
