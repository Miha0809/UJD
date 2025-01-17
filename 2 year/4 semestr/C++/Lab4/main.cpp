#include <iostream>
#include <math.h>

void test1()
{
    /*
    - Zachowaj dokładność do 4 miejsca po przecinku z uwzględnieniem standardowej
    metody zaokrąglania.
    - Nie wpisuj końcowych zer (np. jeśli wynik to 3,23 to tak wpisz w oknie
    odpowiedzi ale nie 3,2300)
    - Podczas wpisywania wyniku użyj przecinka do oddzielenia części całkowitej od
    rzeczywistej wyniku.
    - Pamiętaj, że większość języków programowania obliczenia funkcji
    trygonometrycznych wykonuje w radianach! Przelicz zatem miarę stopniową kąta
    alfa w radiany przed wstawieniem danych do wzoru!
    */

    double x = 4.29383;
    double a = 7.39434;
    double alfa = 45.5;

    alfa = (alfa * M_PI) / 180.0;

    double result = (sqrt((pow(x, 2) - (2 * a)))) / (2 * x) -

                    (sin(alfa)) / (pow(x, 2)) + (tan(alfa)) / (2 * a);

    printf("%.4f\n", result);
}

int check_bit(int number, int bit_position)
{
    int mask = 1 << bit_position;

    if ((number & mask) != 0)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void test2()
{
    int number, bit_position;

    printf("Enter the number: ");
    scanf("%d", &number);

    printf("Enter the bit position: ");
    scanf("%d", &bit_position);

    if (check_bit(number, bit_position))
    {
        printf("Bit at position %d in the number %d is set.\n", bit_position,
               number);
    }
    else
    {
        printf("Bit at position %d in the number %d is not set.\n", bit_position,
               number);
    }
}