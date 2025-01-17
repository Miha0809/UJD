#include <cstring>
#include <iostream>

using namespace std;

int globalInt;
char globalChar;
float globalFloat;
char globalCharArray[10];

void task1(void)
{
    int localInt;
    char localChar;
    float localFloat;
    char localCharArray[10];

    cout << "Memory layout of automatic variables:\n";
    cout << "Address of localInt:       " << &localInt << "\n";
    cout << "Address of localChar:      " << (void *)&localChar << "\n";
    cout << "Address of localFloat:     " << &localFloat << "\n";
    cout << "Address of localCharArray: " << (void *)&localCharArray << "\n";
    cout << "\nMemory layout of global variables:\n";
    cout << "Address of globalInt:       " << &globalInt << "\n";
    cout << "Address of globalChar:      " << (void *)&globalChar << "\n";
    cout << "Address of globalFloat:     " << &globalFloat << "\n";
    cout << "Address of globalCharArray: " << (void *)&globalCharArray << "\n";
    cout << "\nDefault values of automatic variables (uninitialized):\n";
    cout << "localInt:       " << localInt << "\n";
    cout << "localChar:      " << (int)localChar << "\n";
    cout << "localFloat:     " << localFloat << "\n";
    cout << "localCharArray: ";

    for (char c : localCharArray)
    {
        cout << (int)c << " ";
    }

    cout << "\n";
    cout << "\nDefault values of global variables (initialized to zero):\n";
    cout << "globalInt:       " << globalInt << "\n";
    cout << "globalChar:      " << (int)globalChar << "\n";
    cout << "globalFloat:     " << globalFloat << "\n";
    cout << "globalCharArray: ";

    for (char c : globalCharArray)
    {
        cout << (int)c << " ";
    }

    cout << "\n";
}

void task2(void)
{
    char *charPtr = new char[10];
    int *intPtr = new int[3];

    cout << "Contents of the first memory area (char): " << charPtr << endl;
    cout << "Contents of the second memory area (int): ";

    for (int i = 0; i < 3; ++i)
    {
        cout << intPtr[i] << " ";
    }

    cout << endl;

    strcpy(charPtr, "Microsoft");

    cout << "Contents of the first memory area after writing 'Microsoft': "

         << charPtr << endl;

    intPtr[0] = 10;
    intPtr[1] = 20;
    intPtr[2] = 30;

    cout << "Contents of the second memory area after writing values: ";

    for (int i = 0; i < 3; ++i)
    {
        cout << intPtr[i] << " ";
    }

    cout << endl;

    delete[] charPtr;
    delete[] intPtr;
}

void task3(void)
{
    char tab[10] = "Cisco";

    cout << *&tab << endl;
}

void task4(void)
{
    char m[6] = {'C', 'i', 's', 'c', 'o', '\0'};
    char n[10] = "Microsoft";

    cout << *&m << endl;
}

void task5(void)
{
    int a[][2] = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}};
    char b[2][20] = {"Poniedzialek", "Wtorek"};
    char znaki[] = "Programowanie";

    cout << "Array 'a' using indexing:" << endl;

    for (int i = 0; i < 6; ++i)
    {
        for (int j = 0; j < 2; ++j)
        {
            cout << a[i][j] << " ";
        }

        cout << endl;
    }

    cout << "\nArray 'a' using pointers:" << endl;

    for (int i = 0; i < 6; ++i)
    {
        for (int j = 0; j < 2; ++j)
        {
            cout << *(*(a + i) + j) << " ";
        }

        cout << endl;
    }

    cout << "\nArray 'b' using indexing:" << endl;

    for (int i = 0; i < 2; ++i)
    {
        cout << b[i] << endl;
    }

    cout << "\nArray 'b' using pointers:" << endl;

    for (int i = 0; i < 2; ++i)
    {
        cout << *(b + i) << endl;
    }

    cout << "\nArray 'znaki' using indexing:" << endl;

    for (int i = 0; znaki[i] != '\0'; ++i)
    {
        cout << znaki[i];
    }

    cout << endl;
    cout << "\nArray 'znaki' using pointers:" << endl;

    for (char *ptr = znaki; *ptr != '\0'; ++ptr)
    {
        cout << *ptr;
    }

    cout << endl;
}

void task7(void)
{
    char imie[6] = "Pawel";
    int *wsk = nullptr;
    float podatek;
    char napis[124];
    int licznik = 5;
    int x, y, z;

    x = y = z = 3;
    wsk = new int;
    *wsk = 35;
    licznik = 1;
    podatek = 0.23;

    cout << *wsk << endl;

    delete wsk;
}

void task8(void)
{
    char x[2] = "z";
    char z[2] = "a";
    char y = 'z';

    cout << "x: " << x << endl;
    cout << "z: " << z << endl;
    cout << "y: " << y << endl;
}

void task9(void)
{
    // C
    char staticText[256] = "This is a static long text in C.";

    printf("Static text: %s\n", staticText);

    char *dynamicText = (char *)malloc(256 * sizeof(char));

    if (dynamicText != NULL)
    {
        strcpy(dynamicText, "This is a dynamically allocated long text in C.");
        printf("Dynamic text: %s\n", dynamicText);
        free(dynamicText);
    }
    else
    {

        printf("Memory allocation failed.\n");
    }

    // C++
    string longText = "This is a long text stored in a std::string in C++.";
    cout << "Long text: " << longText << endl;

    char cStyleText[256] = "This is a C-style char array in C++.";
    cout << "C-style text: " << cStyleText << endl;
}

void task10(void)
{
    int num;

    cout << "Enter a number: ";
    cin >> num;

    cout << "Address of variable 'num': " << &num << endl;

    for (int i = 0; i < 5; ++i)
    {
        int *dynamicNum = new int;
        *dynamicNum = i;
        cout << "Address of dynamically allocated variable: " << dynamicNum << endl;

        delete dynamicNum;
    }
}

void swap(int *a, int *b)
{
    int temp = *a;

    *a = *b;
    *b = temp;
}

void task22(void)
{
    int a, b;

    cout << "Enter the first number: ";
    cin >> a;

    cout << "Enter the second number: ";
    cin >> b;

    cout << "Before swapping: a = " << a << ", b = " << b << endl;

    swap(&a, &b);

    cout << "After swapping: a = " << a << ", b = " << b << endl;

    int arr[2] = {a, b};

    cout << "Array before swapping: arr[0] = " << arr[0]
         << ", arr[1] = " << arr[1] << endl;

    swap(&arr[0], &arr[1]);

    cout << "Array after swapping: arr[0] = " << arr[0] << ", arr[1] = " << arr[1]
         << endl;
}

void task23(void)
{
    int arr[5] = {0};
    int *ptr = arr;
    int(*ptrArr)[5] = &arr;

    arr[0] = 1;
    *(ptr + 1) = 2;
    *(*ptrArr + 2) = 3;

    cout << "Zawartość tablicy:" << endl;

    for (int i = 0; i < 5; ++i)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}

void task25C(void)
{
    int arr[5] = {1, 2, 3, 4, 5};
    int *ptr = (int *)malloc(5 * sizeof(int));

    if (ptr == NULL)
    {
        printf("Błąd alokacji pamięci.\n");
        return;
    }

    printf("Zawartość tablicy arr:\n");

    for (int i = 0; i < 5; ++i)
    {
        printf("%d ", arr[i]);
    }

    printf("\n");
    printf("Zawartość zaalokowanego obszaru pamięci:\n");

    for (int i = 0; i < 5; ++i)
    {
        printf("%d ", ptr[i]);
    }

    printf("\n");

    for (int i = 0; i < 5; ++i)
    {
        ptr[i] = arr[i];
    }

    printf("Zawartość zaalokowanego obszaru pamięci po przepisaniu:\n");

    for (int i = 0; i < 5; ++i)
    {
        printf("%d ", ptr[i]);
    }

    printf("\n");

    for (int i = 0; i < 5; ++i)
    {
        ptr[i] += 1;
    }

    printf("Zawartość zaalokowanego obszaru pamięci po zwiększeniu o 1:\n");

    for (int i = 0; i < 5; ++i)
    {
        printf("%d ", ptr[i]);
    }

    printf("\n");
    free(ptr);
}

void task25Cpp(void)
{
    int arr[5] = {1, 2, 3, 4, 5};
    int *ptr = new int[5];

    cout << "Zawartość tablicy arr:" << endl;

    for (int i = 0; i < 5; ++i)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
    cout << "Zawartość zaalokowanego obszaru pamięci:" << endl;

    for (int i = 0; i < 5; ++i)
    {
        cout << ptr[i] << " ";
    }

    cout << endl;

    for (int i = 0; i < 5; ++i)
    {
        ptr[i] = arr[i];
    }

    cout << "Zawartość zaalokowanego obszaru pamięci po przepisaniu:" << endl;

    for (int i = 0; i < 5; ++i)
    {
        cout << ptr[i] << " ";
    }

    cout << endl;

    for (int i = 0; i < 5; ++i)
    {
        ptr[i] += 1;
    }

    cout << "Zawartość zaalokowanego obszaru pamięci po zwiększeniu o 1:" << endl;

    for (int i = 0; i < 5; ++i)
    {
        cout << ptr[i] << " ";
    }

    cout << endl;
    delete[] ptr;
}

void task26(void)
{
    int *ptr1;
    int *ptr2 = nullptr;

    cout << "Address of ptr1 (uninitialized): " << ptr1 << endl;
    cout << "Address of ptr2 (initialized with nullptr): " << ptr2 << endl;
    cout << "Contents of *ptr1: " << *ptr1 << endl;
    cout << "Contents of *ptr2: " << *ptr2 << endl;

    int num1 = 10;
    int num2 = 20;

    ptr1 = &num1;
    ptr2 = &num2;

    cout << "\nAddress of ptr1 (after initialization): " << ptr1 << endl;
    cout << "Address of ptr2 (after initialization): " << ptr2 << endl;
    cout << "Contents of *ptr1: " << *ptr1 << endl;
    cout << "Contents of *ptr2: " << *ptr2 << endl;
    cout << "\nAddress of ptr1 (after deallocation): " << ptr1 << endl;
    cout << "Address of ptr2 (after deallocation): " << ptr2 << endl;
    cout << "Contents of *ptr1 (after deallocation): " << *ptr1 << endl;
    cout << "Contents of *ptr2 (after deallocation): " << *ptr2 << endl;
}

void task27(int argc, char **argv)
{
    cout << "Zawartość tablicy argumentów (traktowana jako wskaźnik do znaków):"
         << endl;

    for (int i = 0; i < argc; ++i)
    {
        cout << "Argument " << i << ": " << argv[i] << endl;
    }
}

void task29(void)
{
    int size;
    char userChar;

    do
    {
        cout << "Enter a positive integer for the array size: ";
        cin >> size;

    } while (size <= 0);

    cout << "Enter one character: ";
    cin >> userChar;

    char *arr = new char[size + 1];
    srand(time(nullptr));

    for (int i = 0; i < size; ++i)
    {
        arr[i] = 'a' + rand() % ('Z' - 'a' + 1);
    }

    arr[size] = '\0';
    cout << "Generated array of size " << size
         << " with random characters: " << arr << endl;

    int count = 0;

    for (int i = 0; i < size; ++i)
    {
        if (arr[i] == userChar)
        {
            count++;
        }
    }

    cout << "Number of occurrences of '" << userChar
         << "' in the array: " << count << endl;

    delete[] arr;
}

int main(int argc, char **argv)
{
    cout << endl
         << "Task1!" << endl;
    task1();

    cout << endl
         << "Task2!" << endl;
    task2();

    cout << endl
         << "Task3!" << endl;
    task3();

    cout << endl
         << "Task4!" << endl;
    task4();

    cout << endl
         << "Task5!" << endl;
    task5();

    cout << endl
         << "Task7!" << endl;
    task7();

    cout << endl
         << "Task8!" << endl;
    task8();

    cout << endl
         << "Task9!" << endl;
    task9();

    cout << endl
         << "Task10!" << endl;
    task10();

    cout << endl
         << "Task22!" << endl;
    task22();

    cout << endl
         << "Task23!" << endl;
    task23();

    cout << endl
         << "Task25 for C!" << endl;
    task25C();

    cout << endl
         << "Task25 for C++!" << endl;
    task25Cpp();

    cout << endl
         << "Task26!" << endl;
    // task26();

    cout << endl
         << "Task28!" << endl;
    task27(argc, argv);

    cout << endl
         << "Task29!" << endl;
    task29();

    return 0;
}