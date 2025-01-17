#include <climits>
#include <cmath>
#include <cstdlib>
#include <float.h>
#include <iostream>
#include <ostream>
using namespace std;

void task1() { cout << "Hello, World" << endl; }

void task2() {
  for (int j = 1; j <= 10; j++) {
    for (int i = 1; i <= 10; i++) {
      int k = i * j;
      printf("%4d", k);
    }

    cout << endl;
  }
}

void task3() {
  for (int j = 1; j <= 10; j++) {
    for (int i = 1; i <= 10; i++) {
      int k = i * j;
      printf("%4d", k);
    }

    cout << endl;
  }
}

void task4() {
  int const a = 3;
  int const b = 5;

  cout << (float)a / b << endl;
}

void task5() {
  bool a;
  char b;
  unsigned char c;
  int d;
  unsigned int e;
  long int f;
  long long int g;
  unsigned long long int h;
  float i;
  double j;
  long double k;

  cout << "bool" << " " << sizeof(a) << endl;
  cout << "char" << " " << sizeof(b) << endl;
  cout << "unsigned char" << " " << sizeof(c) << endl;
  cout << "int" << " " << sizeof(b) << endl;
  cout << "unsigned int" << " " << sizeof(e) << endl;
  cout << "long int" << " " << sizeof(f) << endl;
  cout << "long long int" << " " << sizeof(g) << endl;
  cout << "unsigned long long int" << " " << sizeofserce << endl;
  cout << "float" << " " << sizeof(i) << endl;
  cout << "double" << " " << sizeof(j) << endl;
  cout << "long double" << " " << sizeof(k) << endl;
}

void task6() {
  int number = 0;

  cout << "Enter number: ";
  cin >> number;

  if (number >= -10 && number < 20 || number > 0 && number <= 10 ||
      number >= -3 && number <= 3) {
    cout << "1" << endl;
  } else {
    cout << "0" << endl;
  }
}

void task7() {
  int number = 0;

  cout << "Enter number: ";
  cin >> number;

  bool result =
      ((number >= -10 && number < 20) || (number > 30 && number < 40)) ||
              ((number > 0 && number <= 3) || (number >= 5 && number <= 7))
          ? true
          : false;

  cout << result << endl;
}

void task8() {
  double num1 = 0, num2 = 0, num3 = 0;

  cout << "Enter number: ";
  cin >> num1 >> num2 >> num3;

  double suma = num1 + num2 + num3;
  double average = suma / 3;

  cout << "Suma: " << suma << endl;
  cout << "Average: " << average << endl;
}

void task9() {
  const double standardRate = 10.0;
  const double overtimeRate = standardRate * 1.5;
  int standardHours = 0, overtimeHours = 0;
  double totalStandardPay = 0, totalOvertimePay = 0, totalPay = 0,
         percentOvertime;

  cout << "Enter standard hours: ";
  cin >> standardHours;

  cout << "Enter overtime hours: ";
  cin >> overtimeHours;

  totalStandardPay = standardHours * standardRate;
  totalOvertimePay = overtimeHours * overtimeRate;
  totalPay = totalStandardPay + totalOvertimePay;

  percentOvertime =
      (double)(overtimeHours) / (standardHours + overtimeHours) * 100;

  cout << "\nPay for standard hours: $" << totalStandardPay << endl;
  cout << "Pay for overtime hours: $" << totalOvertimePay << endl;
  cout << "Total pay: $" << totalPay << endl;
  cout << "Percentage of overtime hours relative to total hours: "
       << percentOvertime << "%" << endl;
}

void task10() {
  int letter1 = 'A';
  char letter2 = 97;

  cout << "int letter1 = 'A' -> " << letter1 << endl;
  cout << "char letter2 = 97 -> " << letter2 << endl;
}

void task11() {
  long a = 3999999999;
  char b = 'a';
  short c = 23;
  float d = 0.3;

  // long double e = 999e999; ERROR!
  cout << "a " << a << endl;
  cout << "b " << b << endl;
  cout << "c " << c << endl;
  cout << "d " << d << endl;
  // cout << "e " << e << endl;
}

void task12() {
  int maxInt = INT_MAX;
  int minInt = INT_MIN;

  cout << "maxInt: " << maxInt << endl;
  cout << "minInt: " << minInt << endl;

  maxInt++;
  minInt--;

  cout << "++: " << maxInt << endl;
  cout << "--: " << minInt << endl;

  bool maxBool = BOOL_MAX;

  cout << "maxBool" << maxBool << endl;

  long maxLong = LONG_MAX;
  long minLong = LONG_MIN;

  cout << "maxLong: " << maxLong << endl;
  cout << "minLong: " << minLong << endl;

  maxLong++;
  minLong--;

  cout << "++: " << maxLong << endl;
  cout << "--: " << minLong << endl;

  char maxChar = CHAR_MAX;
  char minChar = CHAR_MIN;

  cout << "maxChar: " << maxChar << endl;
  cout << "minChar: " << minChar << endl;

  maxChar++;
  minChar--;

  cout << "++: " << maxChar << endl;
  cout << "--: " << minChar << endl;

  float maxFloat = FLT_MAX;
  float minFloat = FLT_MIN;

  cout << "maxFloat: " << maxFloat << endl;
  cout << "minFloat: " << minFloat << endl;

  maxFloat++;
  minFloat--;

  cout << "++: " << maxFloat << endl;
  cout << "--: " << minFloat << endl;
}

void task12a() {

  int a = 10;

  cout << "a++ >>>" << a << " " << a++ << endl;
  cout << "a >>> " << a << endl;
  cout << "++a >>> " << a << " " << ++a << endl;
}

void task13() {
  int brutto = 0;
  double tax = 0;

  cout << "Enter brutto: ";
  cin >> brutto;

  cout << "Enter tax: ";
  cin >> tax;

  double netto = brutto / (1 + (tax / 100));

  cout << "Przy podatku " << tax << "% z kwoty brutto " << brutto
       << "PLN otrzymujemy kwote netto rowna " << netto
       << "PLN. Wartość podatku to " << (brutto - netto) << "PLN" << endl;
}

void task14() {
  double number = 0;

  cout << "Enter number: ";
  cin >> number;

  cout << "Abs for number: " << abs(number) << endl;
}

void task15() {

  int number = 0;

  cout << "Enter number: ";
  cin >> number;

  cout << "number++ -> " << number++ << endl;
  cout << "number += 1 -> " << (number += 1) << endl;
  cout << "number = number + 1 -> " << (number = number + 1) << endl;
  cout << "++number -> " << ++number << endl;
}

void task16() {

  string type;
  double range = 0;

  cout << "Enter km (km to ml) or ml (ml to km): ";
  cin >> type;

  cout << "Enter range: ";
  cin >> range;

  double result = 0;

  if (type == "km") {
    result = range * 1.6;
  } else if (type == "ml") {
    result = range / 1.6;
  }

  cout << "Result: " << result << endl;
}

void task17() {

  double range = 0;
  double fuel = 0;

  cout << "Enter ranger: ";
  cin >> range;

  cout << "Amount of fuel burned: ";
  cin >> fuel;

  double result = fuel / (range / 100);

  cout << "Result: " << result << endl;
}

void task18() {
  double x = 0;
  double alfa = 0;

  cout << "Enter x: ";
  cin >> x;

  cout << "Enter alfa: ";
  cin >> alfa;

  if (x <= 0 || alfa <= 0) {
    cout << "x <= 0 || alfa <= 0" << endl;
  }

  x = x * M_PI / 180.0;
  alfa = alfa * M_PI / 180.0;

  double result =
      (abs(sin(alfa)) / x) + ((cos(alfa)) / (x * x)) - (x * (1 / log(x)));

  cout << "Result: " << result << endl;
}

int xorOperation(int a, int b) { return (a & ~b) | (~a & b); }

void task19() {
  int x, y;

  cout << "Enter two numbers: ";
  cin >> x >> y;

  int result = xorOperation(x, y);

  cout << "Result XOR operation: " << result << endl;
}

void task20() {
  long long seconds = 0;

  cout << "Enter seconds: ";
  cin >> seconds;

  int days = seconds / 86400;
  seconds %= 86400;
  int hours = seconds / 3600;
  seconds %= 3600;
  int minutes = seconds / 60;
  seconds %= 60;

  cout << "dd:hh:mm:ss " << days << ":" << hours << ":" << minutes << ":"
       << seconds << endl;
}

void task21() {
  // a) Czym się różni znak '3' od cyfry 3 w sensie języka C++
  // '3' to jest char, a 3 to jest short, int lub long
  // b) Co to jest typ danych char i do czego go używamy
  // to jest typ, który przyjmuje tylko 1 znak lub tablicę znaków
  // c) Co to jest typ int i jakie ma zastosowanie
  // int to liczby całkowite
  // d) Podaj różnicę między typem int a float
  // int to liczba człkowita, a float to liczba rzeczywista
  // e) Jaki typ danych zastosujesz w przypadku wyznaczenia kwoty w PLN
  // long double
  // f) Jakie zastosowanie ma stała a jakie zmienna
  // stała nie może zmienić się, a zmienna może
  // g) Jak można zadeklarować stałą
  // const type nameVariable;
  // h) Jak można zmienić wartość stałej
  // nie można
  // i) Podaj różnice pomiędzy == a =
  // Operator '==' porównuje, a '=' przypisuje
  // j) Czym się różni typ od zmiennej
  // zmienna to jest nazwa, która ma dowolną wartość zgodnie z typem
  // k) Omów działanie znanych modyfikatorów zmiennych
  // short, int, long, long long, float, double, char, string, unsigned char,
  // unsigned int, unsigned long long ...
  // l) Które zmienne, ze znakiem czy bez znaku mogą przechowywać większą ilość
  // danych? Podaj powody.
  // nie wiem
  // m) Co to jest rzutowanie i jak się je przeprowadza?
  // rzutowanie to jest (ang.) "cast", czyli przetważamy z jednego typa do
  // drugiego typa
}

int main(void) {

  cout << endl << "Task1!" << endl;
  task1();

  cout << endl << "Task2!" << endl;
  task2();

  cout << endl << "Task3!" << endl;
  task3();

  cout << endl << "Task4!" << endl;
  task4();

  cout << endl << "Task5!" << endl;
  task5();

  cout << endl << "Task6!" << endl;
  task6();

  cout << endl << "Task7!" << endl;
  task7();

  cout << endl << "Task8!" << endl;
  task8();

  cout << endl << "Task9!" << endl;
  task9();

  cout << endl << "Tsak10!" << endl;
  task10();

  cout << endl << "Task11!" << endl;
  task11();

  cout << endl << "Task12!" << endl;
  task12();

  cout << endl << "Task12a!" << endl;
  task12a();

  cout << endl << "Task13!" << endl;
  task13();

  cout << endl << "Task14!" << endl;
  task14();

  cout << endl << "Task15!" << endl;
  task15();

  cout << endl << "Task16!" << endl;
  task16();

  cout << endl << "Task17!" << endl;
  task17();

  cout << endl << "Task18!" << endl;
  task18();

  cout << endl << "Task19!" << endl;
  task19();

  cout << endl << "Task20!" << endl;
  task20();

  return 1;
}
