int sumArray(int arr[], int size)
{
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
        sum += arr[i];
    }
    return sum;
}

int findMax(int arr[], int size)
{
    int max = arr[0];
    for (int i = 1; i < size; i++)
    {
        if (arr[i] > max)
        {
            max = arr[i];
        }
    }
    return max;
}

int main()
{
    int myArray[] = {5, 2, 9, 1, 7};
    int size = 5;

    int sum = sumArray(myArray, size);
    int max = findMax(myArray, size);

    return 0;
}