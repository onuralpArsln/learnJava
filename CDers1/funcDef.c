#include <stdio.h>

void merhaba()
{
    printf("Bu Fonksiyon!\n");
}

int calculate(int a, int b)
{
    return a + b;
}

int main()
{
    merhaba();
    int a = calculate(5, 4);
    printf("%d\n", a);
    return 0;
}
