#include <stdio.h>

struct Student
{
    int id;
    int *class1;
    int *class2;
    int *class3;
};

int main()
{
    int class1[] = {25, 30, 35, 40, 45};
    int class2[] = {15, 18, 65, 19, 17};
    int class3[] = {70, 80, 65, 90, 75};

    struct Student students[5];

    for (int i = 0; i < 5; i++)
    {
        students[i].id = i;
        students[i].class1 = class1;
        students[i].class2 = class2;
        students[i].class3 = class3;
    }

    printf("Class Avarage");

    return 0;
}