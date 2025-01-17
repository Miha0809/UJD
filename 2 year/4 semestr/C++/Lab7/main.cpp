#include <iostream>
#include <cmath>
#include <cstring>

using namespace std;

bool bcdOK(const string &input)
{
    for (char c : input)
    {
        if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')))
        {
            return false;
        }
    }

    return true;
}

void task4(void)
{
    string input1 = "absgdfsr";
    string input2 = "1234ABCF";

    cout << "Czy '" << input1 << "' jest liczba szesnastkowa BCD? "
         << (bcdOK(input1) ? "Tak" : "Nie") << endl;

    cout << "Czy '" << input2 << "' jest liczba szesnastkowa BCD? "
         << (bcdOK(input2) ? "Tak" : "Nie") << endl;
}

void swap(int &a, int &b)
{
    int temp = a;

    a = b;
    b = temp;
}

int compare(int a, int b)
{
    if (a == b)
    {
        return 0;
    }
    else if (a > b)
    {
        return 1;
    }
    else
    {
        return -1;
    }
}

void task5(void)
{
    int x = 5;
    int y = 3;

    cout << "Przed zamianą: x = " << x << ", y = " << y << endl;

    swap(x, y);

    cout << "Po zamianie: x = " << x << ", y = " << y << endl;

    int a = 10;
    int b = 10;

    cout << "Porównanie a i b: " << compare(a, b) << endl;

    a = 15;
    b = 7;

    cout << "Porównanie a i b: " << compare(a, b) << endl;

    a = 3;
    b = 9;

    cout << "Porównanie a i b: " << compare(a, b) << endl;
}

int textLength(const char *text) { return strlen(text); }

void task5a(void)
{
    const char *message = "Hello, World!";
    int length = textLength(message);

    cout << "Length of the text \"" << message << "\" is: " << length << endl;
}

long int squareByValue(long int num) { return num * num; }

void task6(void)
{
    long int number = 5;
    long int squared = squareByValue(number);

    cout << "Liczba " << number << " podniesiona do kwadratu wynosi: " << squared
         << endl;
}

struct IPAddress
{
    unsigned char bytes[4];
};

IPAddress calculateNetworkAddress(const IPAddress &ip,
                                  const IPAddress &subnetMask)
{
    IPAddress networkAddress;

    for (int i = 0; i < 4; ++i)
    {
        networkAddress.bytes[i] = ip.bytes[i] & subnetMask.bytes[i];
    }

    return networkAddress;
}

void printIPAddress(const IPAddress &ip)
{
    cout << (int)ip.bytes[0] << "." << (int)ip.bytes[1] << "." << (int)ip.bytes[2]
         << "." << (int)ip.bytes[3] << endl;
}

void task6a(void)
{
    IPAddress ip = {{192, 168, 1, 10}};
    IPAddress subnetMask = {{255, 255, 255, 0}};
    IPAddress networkAddress = calculateNetworkAddress(ip, subnetMask);

    cout << "Adres IP: ";
    printIPAddress(ip);

    cout << "Maska sieci: ";
    printIPAddress(subnetMask);

    cout << "Adres sieci: ";
    printIPAddress(networkAddress);
}

int calculateArea(int side) { return side * side; }

double calculateArea(double length, double width) { return length * width; }

double calculateVolume(double length, double width = 1.0, double height = 1.0)
{
    return length * width * height;
}

void task7(void)
{
    int choice;

    cout << "Choose an option:\n";
    cout << "1. Area of a square\n";
    cout << "2. Area of a rectangle\n";
    cout << "3. Volume of a cube\n";
    cout << "Your choice: ";
    cin >> choice;

    switch (choice)
    {
    case 1:
    {
        int side;

        cout << "Enter the side length of the square: ";
        cin >> side;

        cout << "The area of the square is: " << calculateArea(side) << endl;

        break;
    }
    case 2:
    {
        double length, width;

        cout << "Enter the length of the rectangle: ";
        cin >> length;

        cout << "Enter the width of the rectangle: ";
        cin >> width;

        cout << "The area of the rectangle is: " << calculateArea(length, width)
             << endl;

        break;
    }
    case 3:
    {
        double length, width, height;

        cout << "Enter the length of the cube: ";
        cin >> length;

        cout << "Enter the width of the cube (default is 1): ";
        cin >> width;

        cout << "Enter the height of the cube (default is 1): ";
        cin >> height;

        cout << "The volume of the cube is: "
             << calculateVolume(length, width, height) << endl;

        break;
    }
    default:
        cout << "Invalid choice. Please try again." << endl;
    }
}

double square(double x) { return x * x; }

double hypotenuse(double a, double b)
{
    if (a <= 0 || b <= 0)
    {
        return -1;
    }

    return sqrt(square(a) + square(b));
}

void task8(void)
{
    double side1, side2;

    cout << "Enter the length of the first side of the right triangle: ";
    cin >> side1;

    cout << "Enter the length of the second side of the right triangle: ";
    cin >> side2;

    double hyp = hypotenuse(side1, side2);

    if (hyp == -1)
    {
        cout << "The lengths entered are invalid (zero or negative)." << endl;
    }
    else
    {
        cout << "The length of the hypotenuse is: " << hyp << endl;
    }
}

int findValue(const int array[], int size, int value)
{
    for (int i = 0; i < size; ++i)
    {
        if (array[i] == value)
        {
            return i;
        }
    }

    return -1;
}

void task8a(void)
{
    int array[] = {2, 5, 7, 1, 4};
    int size = sizeof(array) / sizeof(array[0]);
    int valueToFind = 7;
    int index = findValue(array, size, valueToFind);

    if (index != -1)
    {
        cout << "Value " << valueToFind << " found at index " << index << endl;
    }
    else
    {
        cout << "Value " << valueToFind << " not found in the array." << endl;
    }
}

void modify(int *ptr)
{
    *ptr = 100;
    ptr = nullptr;
}

void task9a(void)
{
    int number = 42;
    int *ptr = &number;

    cout << "Before calling modify function:\n";
    cout << "Value at ptr: " << *ptr << endl;
    cout << "Address stored in ptr: " << ptr << endl;

    modify(ptr);

    cout << "\nAfter calling modify function:\n";
    cout << "Value at ptr: " << *ptr << endl;
    cout << "Address stored in ptr: " << ptr << endl;
    cout << "\nValue of 'number' variable outside function: " << number << endl;
}

enum BitMask
{
    BIT0 = 0x1,  // 0001
    BIT1 = 0x2,  // 0010
    BIT2 = 0x4,  // 0100
    BIT3 = 0x8,  // 1000
    BIT4 = 0x10, // 0001 0000
    BIT5 = 0x20, // 0010 0000
    BIT6 = 0x40, // 0100 0000
    BIT7 = 0x80  // 1000 0000
};

void decToBin(unsigned int num)
{
    for (int bit = sizeof(num) * 8 - 1; bit >= 0; --bit)
    {
        cout << ((num >> bit) & 1);
    }

    cout << endl;
}

int setBit(int &word, int bitNumber)
{
    if (bitNumber < 0 || bitNumber >= sizeof(int) * 8)
    {
        return -3;
    }

    if (word < 0)
    {
        return -1;
    }

    word |= (1 << bitNumber);

    return 0;
}

int clearBit(int &word, int bitNumber)
{
    if (bitNumber < 0 || bitNumber >= sizeof(int) * 8)
    {
        return -3;
    }

    if (word < 0)
    {
        return -1;
    }

    word &= ~(1 << bitNumber);

    return 0;
}

void task10(void)
{
    int word = 13;

    cout << "Original value in binary: ";
    decToBin(word);

    int setResult = setBit(word, 2);

    if (setResult == 0)
    {
        cout << "After setting bit 2, value in binary: ";
        decToBin(word);
    }
    else
    {
        cout << "Error setting bit: " << setResult << endl;
    }

    int clearResult = clearBit(word, 3);

    if (clearResult == 0)
    {
        cout << "After clearing bit 3, value in binary: ";
        decToBin(word);
    }
    else
    {
        cout << "Error clearing bit: " << clearResult << endl;
    }
}

void lostab(int t[], int size, int n)
{
    srand(time(NULL));

    for (int i = 0; i < size; ++i)
    {
        t[i] = rand() % (n + 1);
    }
}

int znajdzN(int t[], int size, int n)
{
    int count = 0;

    for (int i = 0; i < size; ++i)
    {
        if (t[i] == n)
        {
            count++;
        }
    }

    return count;
}

void task12(void)
{
    const int SIZE = 10;
    int tablica[SIZE];

    lostab(tablica, SIZE, 5);

    int liczbaN = 5;
    int iloscWystapien = znajdzN(tablica, SIZE, liczbaN);

    cout << "Liczba wystąpień liczby " << liczbaN
         << " w tablicy: " << iloscWystapien << endl;
}

void swapPointers(int *ptr1, int *ptr2)
{
    int temp = *ptr1;

    *ptr1 = *ptr2;
    *ptr2 = temp;
}

void swapReferences(int &ref1, int &ref2)
{
    int temp = ref1;

    ref1 = ref2;
    ref2 = temp;
}

void swapPointerAndReference(int *ptr, int &ref)
{
    int temp = *ptr;

    *ptr = ref;
    ref = temp;
}

void task13(void)
{
    int num1 = 10, num2 = 20;
    int *ptr1 = &num1;
    int *ptr2 = &num2;

    cout << "Before swapping using pointers:\n";
    cout << "num1 = " << num1 << ", num2 = " << num2 << endl;

    swapPointers(ptr1, ptr2);

    cout << "After swapping using pointers:\n";
    cout << "num1 = " << num1 << ", num2 = " << num2 << endl;
    cout << "\nResetting values for swapping using references:\n";

    num1 = 10;
    num2 = 20;

    cout << "Before swapping using references:\n";
    cout << "num1 = " << num1 << ", num2 = " << num2 << endl;

    swapReferences(num1, num2);

    cout << "After swapping using references:\n";
    cout << "num1 = " << num1 << ", num2 = " << num2 << endl;
    cout << "\nResetting values for swapping pointer and reference:\n";

    num1 = 10;
    num2 = 20;

    cout << "Before swapping pointer and reference:\n";
    cout << "num1 = " << num1 << ", num2 = " << num2 << endl;

    swapPointerAndReference(&num1, num2);

    cout << "After swapping pointer and reference:\n";
    cout << "num1 = " << num1 << ", num2 = " << num2 << endl;
}

int *allocateMemory() { return new int; }

int *allocateAndInitialize(int value)
{
    int *ptr = new int;
    *ptr = value;

    return ptr;
}

void task14(void)
{
    int *ptr1 = allocateMemory();

    *ptr1 = 42;
    cout << "Value allocated using allocateMemory(): " << *ptr1 << endl;

    delete ptr1;

    int *ptr2 = allocateAndInitialize(99);

    cout << "Value allocated and initialized using allocateAndInitialize(): "
         << *ptr2 << endl;

    delete ptr2;
}

int function(int i, int array[], int n)
{
    int count = 0;

    for (int j = 0; j < n; ++j)
    {
        if (array[j] != 0)
        {
            count++;

            if (count == i)
            {
                return array[j];
            }
        }
    }

    return 0;
}

void task15(void)
{
    int array[] = {0, 3, 0, 5, 0, 7};
    int n = sizeof(array) / sizeof(array[0]);
    int i = 2;
    int result = function(i, array, n);

    cout << "Value of the " << i
         << "-th element of the array (non-zero): " << result << endl;
}

int *allocateAndFill(int n)
{
    int *block = new int[n];

    for (int i = 0; i < n; ++i)
    {
        block[i] = i + 1;
    }

    return block;
}

void task15_2(void)
{
    int number;

    cout << "Enter the number of integers to allocate: ";
    cin >> number;

    int *block = allocateAndFill(number);
    cout << "Contents of the allocated block:" << endl;

    for (int i = 0; i < number; ++i)
    {
        cout << block[i] << " ";
    }

    cout << endl;

    delete[] block;
}

void convertSeconds(int inputSeconds, int &days, int &hours, int &minutes,
                    int &seconds)
{
    const int SECONDS_IN_DAY = 86400;
    const int SECONDS_IN_HOUR = 3600;
    const int SECONDS_IN_MINUTE = 60;

    days = inputSeconds / SECONDS_IN_DAY;
    inputSeconds %= SECONDS_IN_DAY;
    hours = inputSeconds / SECONDS_IN_HOUR;
    inputSeconds %= SECONDS_IN_HOUR;
    minutes = inputSeconds / SECONDS_IN_MINUTE;
    seconds = inputSeconds % SECONDS_IN_MINUTE;
}

void task16(void)
{
    int totalSeconds;
    int days, hours, minutes, seconds;

    cout << "Enter the number of seconds: ";
    cin >> totalSeconds;

    convertSeconds(totalSeconds, days, hours, minutes, seconds);

    cout << totalSeconds << " seconds is equivalent to:\n";
    cout << "Days: " << days << endl;
    cout << "Hours: " << hours << endl;
    cout << "Minutes: " << minutes << endl;
    cout << "Seconds: " << seconds << endl;
}

void copyConstantToVariable(const int *constPtr, int *varPtr)
{
    *varPtr = *constPtr;
}

void copyConstantToVariable(const int *const constPtr, const int *varPtr)
{
    *const_cast<int *>(varPtr) = *constPtr;
}

void task16_2(void)
{
    int constantValue = 10;
    int variableValue = 0;
    const int *ptrToConstant = &constantValue;
    int *ptrToVariable = &variableValue;

    cout << "Before calling copyConstantToVariable function:" << endl;
    cout << "constantValue: " << constantValue << endl;
    cout << "variableValue: " << variableValue << endl;

    copyConstantToVariable(ptrToConstant, ptrToVariable);

    cout << "\nAfter calling copyConstantToVariable function:" << endl;
    cout << "constantValue: " << constantValue << endl;
    cout << "variableValue: " << variableValue << endl;

    constantValue = 20;

    cout << "\nAfter updating constantValue:" << endl;
    cout << "constantValue: " << constantValue << endl;
    cout << "variableValue: " << variableValue << endl;

    int newValue = 30;

    ptrToVariable = &newValue;

    cout << "\nAfter changing ptrToVariable to point to newValue:" << endl;
    cout << "constantValue: " << constantValue << endl;
    cout << "variableValue: " << variableValue << endl;
}

int countBits(int number)
{
    int count = 0;

    while (number > 0)
    {
        count += number & 1;
        number >>= 1;
    }

    return count;
}

void task18(void)
{
    int inputNumber;

    cout << "Enter a number: ";
    cin >> inputNumber;

    int bitsSetToOne = countBits(inputNumber);

    cout << "Number of bits set to 1 in " << inputNumber << ": " << bitsSetToOne
         << endl;
}

int calculateEffectiveLength(const string &str)
{
    int length = 0;

    for (char ch : str)
    {
        if (!isspace(ch))
        {
            length++;
        }
    }

    return length;
}

void task19(void)
{
    string inputString;

    cout << "Enter a string: ";
    cin >> inputString;

    int effectiveLength = calculateEffectiveLength(inputString);

    cout << "Effective length of the string: " << effectiveLength << endl;
}

int isLeapYear(int year)
{
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void task20(void)
{
    int year;

    cout << "Enter a year: ";
    cin >> year;

    int leapYear = isLeapYear(year);

    cout << "Is " << year << " a leap year? " << leapYear << endl;
}

void fillArray(int size, int array[])
{
    for (int i = 0; i < size; ++i)
    {
        array[i] = i;
    }
}

void copyArray(int *arr1, int *arr2, int size)
{
    for (int i = 0; i < size; ++i)
    {
        arr2[i] = arr1[i];
    }
}

void displayArray(int size, int arr[])
{
    cout << "Array elements:" << endl;

    for (int i = 0; i < size; ++i)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}

void task20_2(void)
{
    const int size = 5;
    int array1[size];
    int array2[size];

    fillArray(size, array1);
    displayArray(size, array1);
    copyArray(array1, array2, size);
    displayArray(size, array2);
}

int hexToDecimal(string hex)
{
    int decimal = 0;
    int power = 0;

    for (int i = hex.size() - 1; i >= 2; --i)
    {
        char digit = hex[i];
        int value;

        if (isdigit(digit))
        {
            value = digit - '0';
        }
        else
        {
            value = toupper(digit) - 'A' + 10;
        }

        decimal += value * pow(16, power);
        ++power;
    }

    return decimal;
}

void task21(void)
{
    string hexNumber;

    cout << "Enter a hexadecimal number (starting with 0x or 0X): ";
    cin >> hexNumber;

    int decimalNumber = hexToDecimal(hexNumber);

    cout << "Decimal equivalent of " << hexNumber << " is: " << decimalNumber
         << endl;
}

void shiftArray(int array[], int size, int direction = 1, int steps = 1)
{
    if (direction == 1)
    {
        for (int i = 0; i < steps; ++i)
        {
            int last = array[size - 1];

            for (int j = size - 1; j > 0; --j)
            {
                array[j] = array[j - 1];
            }

            array[0] = last;
        }
    }
    else if (direction == -1)
    {
        for (int i = 0; i < steps; ++i)
        {
            int first = array[0];

            for (int j = 0; j < size - 1; ++j)
            {
                array[j] = array[j + 1];
            }

            array[size - 1] = first;
        }
    }
}

void displayArray(int array[], int size)
{
    cout << "Array elements:" << endl;

    for (int i = 0; i < size; ++i)
    {
        cout << array[i] << " ";
    }

    cout << endl;
}

void task21_2(void)
{
    const int size = 5;
    int arr[size] = {1, 2, 3, 4, 5};

    displayArray(arr, size);
    shiftArray(arr, size);
    displayArray(arr, size);
    shiftArray(arr, size, -1);
    displayArray(arr, size);
    shiftArray(arr, size, 1, 2);
    displayArray(arr, size);
}

void calculate(int a, int b, int *sum, int *product)
{
    *sum = a + b;
    *product = a * b;
}

void task24(void)
{
    int num1, num2, sum, product;

    cout << "Enter two numbers: ";
    cin >> num1 >> num2;

    calculate(num1, num2, &sum, &product);

    cout << "Sum of " << num1 << " and " << num2 << " is: " << sum << endl;
    cout << "Product of " << num1 << " and " << num2 << " is: " << product
         << endl;

    if (num2 != 0)
    {
        double quotient = static_cast<double>(num1) / num2;

        cout << "Quotient of " << num1 << " and " << num2 << " is: " << quotient
             << endl;
    }
    else
    {
        cout << "Cannot divide by zero.\n";
    }
}

void symmetry(int array[], int size, int *&first, int *&last, bool &found,
              int &symmetricIndex, int &symmetricValue)
{
    found = false;
    symmetricIndex = -1;

    for (int i = 0; i < size / 2; ++i)
    {
        if (array[i] == array[size - 1 - i])
        {
            found = true;
            symmetricIndex = i;
            symmetricValue = array[i];
            first = &array[i];
            last = &array[size - 1 - i];
            return;
        }
    }
}

void task27(void)
{
    const int size = 8;
    int arr[size] = {1, 2, 3, 4, 4, 3, 2, 1};
    int *firstPtr;
    int *lastPtr;
    bool symmetryFound;
    int symIndex;
    int symValue;

    symmetry(arr, size, firstPtr, lastPtr, symmetryFound, symIndex, symValue);

    if (symmetryFound)
    {
        cout << "Symmetry found!\n";
        cout << "First value: " << *firstPtr << " at index " << firstPtr - arr
             << endl;
        cout << "Last value: " << *lastPtr << " at index " << lastPtr - arr << endl;
        cout << "Symmetric index: " << symIndex << " with value: " << symValue
             << endl;
    }
    else
    {
        cout << "No symmetry found in the array.\n";
    }
}

int main(void)
{
    cout << endl
         << "Task4!" << endl;
    task4();

    cout << endl
         << "Task5!" << endl;
    task5();

    cout << endl
         << "Task5a!" << endl;
    task5a();

    cout << endl
         << "Task6!" << endl;
    task6();

    cout << endl
         << "Task6a!" << endl;
    task6a();

    cout << endl
         << "Task7!" << endl;
    task7();

    cout << endl
         << "Task8!" << endl;
    task8();

    cout << endl
         << "Task8a!" << endl;
    task8a();

    cout << endl
         << "Task9a!" << endl;
    task9a();

    cout << endl
         << "Task10!" << endl;
    task10();

    cout << endl
         << "Task12!" << endl;
    task12();

    cout << endl
         << "Task13!" << endl;
    task13();

    cout << endl
         << "Task14!" << endl;
    task14();

    cout << endl
         << "Task15!" << endl;
    task15();

    cout << endl
         << "Task15_2!" << endl;
    task15_2();

    cout << endl
         << "Task16!" << endl;
    task16();

    cout << endl
         << "Task16_2!" << endl;
    task16_2();

    cout << endl
         << "Task18!" << endl;
    task18();

    cout << endl
         << "Task19!" << endl;
    task19();

    cout << endl
         << "Task20!" << endl;
    task20();

    cout << endl
         << "Task20_2!" << endl;
    task20_2();

    cout << endl
         << "Task21!" << endl;
    task21();

    cout << endl
         << "Task21_2!" << endl;
    task21_2();

    cout << endl
         << "Task24!" << endl;
    task24();

    cout << endl
         << "Task27!" << endl;
    task27();

    return 0;
}