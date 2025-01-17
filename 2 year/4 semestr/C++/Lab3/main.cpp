#include <climits>
#include <cmath>
#include <cstdlib>
#include <iomanip>
#include <iostream>

using namespace std;

void task0()
{
  int num1 = 0, num2 = 0;

  cout << "Enter two numbers: ";
  cin >> num1 >> num2;

  int suma = num1 + num2;

  if (suma % 2 == 0)
  {
    cout << "Suma " << suma << " is even" << endl;
  }
  else
  {
    cout << "Suma " << suma << " is not even" << endl;
  }
}

void task0a()
{
  short age = 0;
  char gender;

  cout << "M -> Male" << endl;
  cout << "W -> Wooman" << endl;
  cout << "Enter age: ";
  cin >> age;

  cout << "Enter gender: ";
  cin >> gender;

  const short pensionForMale = 68;
  const short pensionForWooman = 65;

  if (gender == 'M' || gender == 'm')
  {
    if (age < pensionForMale)
    {
      cout << (pensionForMale - age) << " years left" << endl;
    }
    else
    {
      cout << "You can retire" << endl;
    }
  }
  else if (gender == 'W' || gender == 'w')
  {
    if (age < pensionForWooman)
    {
      cout << (pensionForWooman - age) << " years left" << endl;
    }
    else
    {
      cout << "You can retire" << endl;
    }
  }
}

void task0b()
{
  int number = 0;

  cout << "Enter number: ";
  cin >> number;

  if (number < 0)
  {
    cout << "number < 0" << endl;
  }

  for (int i = 1; i <= number; i++)
  {
    cout << i << " ";
  }

  cout << endl;
}

void task0c()
{
  int number = 0;

  cout << "Enter number: ";
  cin >> number;

  // TODO: make
}

void task0d()
{
  int number = 0;

  cout << "Enter number: ";
  cin >> number;

  string isEvent = number >= 0 ? "posotive" : "negative";

  cout << "Numebr is " << isEvent << endl;
}

void task1()
{
  int number = 0;

  cout << "Enter number: ";
  cin >> number;

  if (number >= 0)
  {
    cout << number << endl;
  }
  else
  {
    cout << (number * (-1)) << endl;
  }
}

void task1a()
{
  char input;
  int ones = 0;
  int errors = 0;
  cout << "Enter binary digits (0 or 1), press Enter to finish:\n";

  while (true)
  {
    cin >> input;

    if (input == 'e' || input == 'E')
    {
      break;
    }
    else if (input != '0' && input != '1')
    {
      errors++;
      continue;
    }
    if (input == '1')
    {
      ones++;
    }
  }

  cout << "Total number of ones: " << ones << endl;
  cout << "Total number of errors: " << errors << endl;
}

void task1b()
{
  int number = 0, pow = 0;

  cout << "Enter number: ";
  cin >> number;

  cout << "Enter pow: ";
  cin >> pow;

  int suma = 1;

  for (int i = 0; i < pow; i++)
  {
    suma *= number;
  }

  cout << "suma for: " << suma << endl;
  suma = 1;

  int i = 0;

  while (i != pow)
  {
    suma *= number;
    i++;
  }

  cout << "suma while: " << suma << endl;
  suma = 1;
  i = 0;

  do
  {
    suma *= number;
    i++;
  } while (i != pow);

  cout << "suma do while " << suma << endl;
}

int rnd(int min, int max)
{
  return min + rand() % max;
}

void task2()
{
  int random = rnd(1, 100);
  int number = 0;
  int count = 0;
  cout << random << endl;

  do
  {
    cout << "Enter number: ";
    cin >> number;

    count++;

    if (number > random)
    {
      cout << "too many" << endl;
    }
    else if (number < random)
    {
      cout << "too little" << endl;
    }
  } while (number != random);

  cout << "Random number: " << random << endl;
  cout << "Counter: " << count << endl;
}

void task3()
{
  cout << "This program calculates the root of a linear equation ax + b = 0."
       << endl;
  cout << "Please enter the coefficients a and b: ";

  double a, b;
  cin >> a >> b;

  if (a == 0)
  {
    if (b == 0)
    {
      cout << "The equation is satisfied for all real numbers." << endl;
    }
    else
    {
      cout << "The equation has no solution." << endl;
    }
  }
  else
  {
    double root = -b / a;
    cout << "The root of the equation is: " << root << endl;
  }
}

void task4()
{
  cout << "This program calculates the solutions of a quadratic equation ax^2 "
          "+ bx + c = 0."
       << endl;
  cout << "Please enter the coefficients a, b, and c: ";

  double a, b, c;
  cin >> a >> b >> c;

  if (a == 0)
  {
    if (b == 0)
    {
      if (c == 0)
      {
        cout << "Infinite number of solutions (equation is satisfied for all "
                "real numbers)."
             << endl;
      }
      else
      {
        cout << "No solutions." << endl;
      }
    }
    else
    {
      double root = -c / b;
      cout << "One real solution: " << root << endl;
    }
  }
  else
  {
    double discriminant = b * b - 4 * a * c;

    if (discriminant > 0)
    {
      double root1 = (-b + sqrt(discriminant)) / (2 * a);
      double root2 = (-b - sqrt(discriminant)) / (2 * a);

      cout << "Two real solutions: " << root1 << " and " << root2 << endl;
    }
    else if (discriminant == 0)
    {
      double root = -b / (2 * a);

      cout << "One real solution: " << root << endl;
    }
    else
    {
      cout << "No real solutions." << endl;
    }
  }
}

void task5()
{
  cout << "This program calculates the total annual income and the average "
          "income."
       << endl;

  double monthly_income, annual_income = 0;
  const int months = 12;

  for (int i = 1; i <= months; ++i)
  {
    cout << "Enter income for month " << i << ": ";
    cin >> monthly_income;
    annual_income += monthly_income;
  }

  double average_income = annual_income / months;

  cout << "Total annual income: " << annual_income << endl;
  cout << "Average monthly income: " << average_income << endl;
}

void task5a()
{
  float f = 1.0f;
  double d = 1.0;
  long double ld = 1.0l;
  int significant_digits_float = 0;
  int significant_digits_double = 0;
  int significant_digits_long_double = 0;

  while (f + 1.0f != 1.0f)
  {
    f /= 10.0f;
    ++significant_digits_float;
  }

  while (d + 1.0 != 1.0)
  {
    d /= 10.0;
    ++significant_digits_double;
  }

  while (ld + 1.0l != 1.0l)
  {
    ld /= 10.0l;
    ++significant_digits_long_double;
  }

  cout << setprecision(20);
  cout << "Significant digits for float: " << significant_digits_float << endl;
  cout << "Significant digits for double: " << significant_digits_double
       << endl;
  cout << "Significant digits for long double: "
       << significant_digits_long_double << endl;
}

void task5b()
{
  long double suma = 0;

  for (long long i = 1; i <= 100000000; i++)
  {
    suma += ((float)1 / (i * i));
  }

  cout << "suma from 1 to 100000000 -> " << suma << endl;
  suma = 0;

  for (long long i = 100000000; i >= 1; i--)
  {
    suma += ((float)1 / (i * i));
  }

  cout << "suma from 100000000 to 1 -> " << suma << endl;
}

void task6()
{
  int num1 = 0, num2 = 0;

  cout << "Enter num1: ";
  cin >> num1;

  cout << "Enter num2: ";
  cin >> num2;

  num1 = abs(num1);
  num2 = abs(num2);

  if (num1 > num2)
  {
    cout << num1 << endl;
  }
  else if (num2 > num1)
  {
    cout << num2 << endl;
  }
  else
  {
    cout << "num1 == num2" << endl;
  }
}

void task7()
{
  cout << "Choose a shape: " << endl;
  cout << "1. Square" << endl;
  cout << "2. Rectangle" << endl;
  cout << "3. Triangle" << endl;

  int choice;
  cin >> choice;

  switch (choice)
  {
  case 1:
  {
    double side;

    cout << "Enter the length of the side of the square: ";
    cin >> side;

    double area_square = side * side;
    cout << "Area of the square: " << area_square << endl;

    break;
  }
  case 2:
  {
    double length, width;

    cout << "Enter the length of the rectangle: ";
    cin >> length;

    cout << "Enter the width of the rectangle: ";
    cin >> width;

    double area_rectangle = length * width;
    cout << "Area of the rectangle: " << area_rectangle << endl;

    break;
  }
  case 3:
  {
    double base, height;

    cout << "Enter the base length of the triangle: ";
    cin >> base;

    cout << "Enter the height of the triangle: ";
    cin >> height;

    double area_triangle = 0.5 * base * height;
    cout << "Area of the triangle: " << area_triangle << endl;

    break;
  }
  default:
    cout << "Invalid choice!" << endl;
  }
}

void task8()
{
  int n;

  cout << "Enter a non-negative integer: ";
  cin >> n;

  if (n < 0)
  {
    cout << "Invalid input! Please enter a non-negative integer." << endl;
  }
  else
  {
    int factorial = 1;

    for (int i = 2; i <= n; ++i)
    {
      factorial *= i;
    }

    cout << "Factorial of " << n << " is: " << factorial << endl;
  }
}

void task9()
{
  int number = 0;

  cout << "Enter number: ";
  cin >> number;

  long long suma = 0;

  for (int i = 0; i <= number; i++)
  {
    suma += pow(i, 2);
  }

  cout << "Suma: " << suma << endl;
}

void task10()
{
  int num1 = 0, num2 = 0;

  cout << "Enter num1: ";
  cin >> num1;

  cout << "Enter num2: ";
  cin >> num2;

  if (num1 > num2)
  {
    cout << "num1 > num2" << endl;

    return;
  }

  long long suma = 1;

  for (int i = num1; i <= num2; i++)
  {
    suma *= i;
  }

  cout << "suma: " << suma << endl;
}

void task11()
{
  long long suma = 0;
  int max = INT_MIN;
  int min = INT_MAX;
  int count = -1;
  int number;

  do
  {
    cout << ">>> ";
    cin >> number;

    if (number < min)
    {
      min = number;
    }
    else if (number > max)
    {
      max = number;
    }

    count++;
    suma += number;

  } while (number != 0);

  double average = suma / (float)count;

  cout << "suma: " << suma << endl;
  cout << "average: " << average << endl;
  cout << "max: " << max << endl;
  cout << "min: " << min << endl;
  cout << "count: " << count << endl;
}

void task12()
{

  cout << "This program calculates the employee's salary based on the number "
          "of hours worked and the hourly rate."
       << endl;
  cout << "Please enter the number of hours worked and the hourly rate: ";

  double hours_worked, hourly_rate;
  cin >> hours_worked >> hourly_rate;

  double salary = hours_worked * hourly_rate;
  int full_days = (int)hours_worked / 8;
  int remaining_hours = (int)hours_worked % 8;

  cout << "Salary: " << salary << endl;
  cout << "Full days worked: " << full_days << endl;
  cout << "Remaining hours: " << remaining_hours << endl;
}

void task13()
{
  short length = 0;

  cout << "Enter length: ";
  cin >> length;

  for (short i = 0; i < length; i++)
  {
    for (short j = 0; j <= i; j++)
    {
      cout << "* ";
    }

    cout << endl;
  }
}

void task14()
{

  short mode = 0;

  cout << "1 - add" << endl;
  cout << "2 - sub" << endl;
  cout << "3 - multi" << endl;
  cout << "4 - div" << endl;
  cout << ">>> ";
  cin >> mode;

  double num1 = 0, num2 = 0;

  cout << "Enter num1: ";
  cin >> num1;

  cout << "Enter num2: ";
  cin >> num2;

  double result = 0;

  switch (mode)
  {
  case 1:
    result = num1 + num2;
    break;
  case 2:
    result = num1 - num2;
    break;
  case 3:
    result = num1 * num2;
    break;
  case 4:
    result = num1 / num2;
    break;
  default:
    break;
  }

  cout << "Result: " << result << endl;
}

void task15()
{
  int a = 0, b = 0;

  cout << "Enter a: ";
  cin >> a;

  cout << "Enter b: ";
  cin >> b;

  if (a > b)
  {
    cout << "a > b" << endl;

    return;
  }

  for (int i = b; i >= a; i--)
  {
    cout << i << " ";
  }

  cout << endl;
}

void task16()
{
  int random = rnd(1, 100);
  int number = 0;
  int count = 0;

  cout << random << endl;

  do
  {
    cout << "Enter number: ";
    cin >> number;

    count++;

    if (number > random)
    {
      cout << "too many" << endl;
    }
    else if (number < random)
    {
      cout << "too little" << endl;
    }
  } while (number != random);

  cout << "Random number: " << random << endl;
  cout << "Counter: " << count << endl;
}

void task16a()
{
  int matches = 11;
  int player = 1;

  cout << "Welcome to the game of 11 Matches!" << endl;
  cout << "There are 11 matches on the table." << endl;

  while (matches > 0)
  {
    cout << "Player " << player
         << ", how many matches do you want to take? (1-3): ";

    int taken;
    cin >> taken;

    if (taken < 1 || taken > 3 || taken > matches)
    {
      cout << "Invalid input! Please take 1, 2, or 3 matches." << endl;

      continue;
    }

    matches -= taken;

    if (matches == 0)
    {
      cout << "Player " << player << " wins!" << endl;

      break;
    }

    cout << "There are " << matches << " matches left." << endl;
    player = (player == 1) ? 2 : 1;
  }
}

void task17()
{
  cout << "Welcome to the number guessing game!" << endl;
  cout << "Enter the range limit (number): ";

  int number;
  cin >> number;

  int low = 1;
  int high = number;

  cout << "Think of a number between 1 and " << number
       << " and I will try to guess it." << endl;

  while (low <= high)
  {
    int guess = (low + high) / 2;

    cout
        << "Is your number " << guess
        << "? (answer with 'm'(too much) or 'l'(too little) or 'c'(correct)): ";

    char answer;
    cin >> answer;

    if (answer == 'c')
    {
      cout << "I guessed it! Thanks for playing." << endl;

      break;
    }
    else if (answer == 'm')
    {
      high = guess - 1;
    }
    else if (answer == 'l')
    {
      low = guess + 1;
    }
    else
    {

      cout << "Invalid input! Please answer with 'too much', 'too little', or "
              "'correct'."
           << endl;
    }
  }
}

void task18()
{
  int rangeMin = 0;
  int rangeMax = 0;

  cout << "Enter begin range: ";
  cin >> rangeMin;

  cout << "Enter end range: ";
  cin >> rangeMax;

  if (rangeMax < rangeMin || rangeMin < 0 || rangeMax < 0)
  {
    cout << "ERROR with range" << endl;

    return;
  }

  long long suma = 0;

  for (int i = rangeMin; i <= rangeMax; i++)
  {
    if (i % 2 != 0)
    {
      suma += i;
    }
  }

  cout << "suma: " << suma << endl;
}

void task19()
{
  int num1 = 0, num2 = 0, num3 = 0;

  cout << "Enter num1: ";
  cin >> num1;

  cout << "Enter num2: ";
  cin >> num2;

  cout << "Enter num3: ";
  cin >> num3;

  if (num1 > num2)
  {
    cout << "Max: " << num1 << endl;
  }
  else if (num2 > num3)
  {
    cout << "Max: " << num2 << endl;
  }
  else if (num3 > num1)
  {
    cout << "Max: " << num3 << endl;
  }
}

void task20()
{
  string word = "";

  cout << "Enter word: ";
  cin >> word;

  for (int i = 0; i < word.length(); i++)
  {
    if (word[i] != word[word.length() - i - 1])
    {
      cout << "NON" << endl;

      return;
    }
  }

  cout << "Word is palindrom" << endl;
}

int main(void)
{
  srand((unsigned)time(NULL));

  cout << endl
       << "Task0" << endl;
  task0();

  cout << endl
       << "Task0a" << endl;
  task0a();

  cout << endl
       << "Task0b" << endl;
  task0b();

  cout << endl
       << "Task0c" << endl;
  task0c();

  cout << endl
       << "Task0d" << endl;
  task0d();

  cout << endl
       << "Task1" << endl;
  task1();

  cout << endl
       << "Task1a" << endl;
  task1a();

  cout << endl
       << "Task1b" << endl;
  task1b();

  cout << endl
       << "Task2" << endl;
  task2();

  cout << endl
       << "Task3" << endl;
  task3();

  cout << endl
       << "Task4" << endl;
  task4();

  cout << endl
       << "Task5" << endl;
  task5();

  cout << endl
       << "Task5a" << endl;
  task5a();

  cout << endl
       << "Task5b" << endl;
  task5b();

  cout << endl
       << "Task6" << endl;
  task6();

  cout << endl
       << "Task7" << endl;
  task7();

  cout << endl
       << "Task8" << endl;
  task8();

  cout << endl
       << "Task9" << endl;
  task9();

  cout << endl
       << "Task10" << endl;
  task10();

  cout << endl
       << "Task11" << endl;
  task11();

  cout << endl
       << "Task12" << endl;
  task12();

  cout << endl
       << "Task13" << endl;
  task13();

  cout << endl
       << "Task14" << endl;
  task14();

  cout << endl
       << "Task15" << endl;
  task15();

  cout << endl
       << "Task16" << endl;
  task16();

  cout << endl
       << "Task16a" << endl;
  task16a();

  cout << endl
       << "Task17" << endl;
  task17();

  cout << endl
       << "Task18" << endl;
  task18();

  cout << endl
       << "Task19" << endl;
  task19();

  cout << endl
       << "Task20" << endl;
  task20();

  return 1;
}