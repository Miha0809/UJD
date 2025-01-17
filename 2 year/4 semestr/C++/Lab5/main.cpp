#include <cmath>
#include <cstring>
#include <iostream>

using namespace std;

const int LENGTH = 10;

void init_array(int *numbers, int range = 1000, int length = LENGTH)
{
  for (int i = 0; i < length; i++)
  {
    int random = rand() % range;
    numbers[i] = random;
  }
}

void print_array(int *numbers, int length = LENGTH)
{
  for (int i = 0; i < length; i++)
  {
    cout << numbers[i] << " ";
  }

  cout << endl;
}

void task4(void)
{
  int numbers[LENGTH];

  init_array(numbers, LENGTH);

  for (int i = 0; i < LENGTH; i++)
  {
    for (int j = i + 1; j < LENGTH; j++)
    {
      if (numbers[i] > numbers[j])
      {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
      }
    }
  }

  print_array(numbers, LENGTH);
}

void reverse(int *numbers, int length)
{
  int end = length % 2 == 0 ? length / 2 - 1 : length / 2;

  for (int i = 0; i < end; i++)
  {
    int temp = numbers[end - i - 1];
    numbers[end - i - 1] = numbers[i];
    numbers[i] = temp;
  }
}

void task6(void)
{
  int numbers[LENGTH];

  init_array(numbers, LENGTH);

  int middle = floor(LENGTH / 2);

  if (LENGTH % 2 != 0)
  {
    cout << numbers[middle] << endl
         << middle << endl;
  }
  else
  {
    cout << numbers[middle - 1] << ", " << numbers[middle] << endl;
  }

  cout << "BEFORE" << endl;
  print_array(numbers, LENGTH);

  reverse(numbers, LENGTH);

  cout << endl
       << "AFTER" << endl;
  print_array(numbers, LENGTH);
}

void task7(void)
{
  const int length = 1000;
  int numbers[length];
  int countEvent = 0;
  int sumaEvent = 0;
  int countNotEvent = 0;
  int sumaNotEvent = 0;
  int count3 = 0;

  init_array(numbers, length);

  for (int i = 0; i < length; i++)
  {
    if (numbers[i] % 2 == 0)
    {
      countEvent++;
      sumaEvent++;
    }
    else if (numbers[i] % 2 != 0)
    {
      countNotEvent++;
      sumaNotEvent++;
    }

    if (numbers[i] % 3 == 0)
    {
      count3++;
    }
  }

  cout << "count event: " << countEvent << endl;
  cout << "suma event: " << sumaEvent << endl;
  cout << "count not event: " << countNotEvent << endl;
  cout << "suma not event: " << sumaNotEvent << endl;
  cout << "count numbers % 3: " << count3 << endl;
}

void drawWithRepetition(void)
{
  int result[6];

  for (int i = 0; i < 6; ++i)
  {
    result[i] = rand() % 49 + 1;
  }

  cout << "6 out of 49 (with repetitions): ";

  for (int i = 0; i < 6; ++i)
  {
    cout << result[i] << " ";
  }

  cout << endl;
}
void drawWithRepetitionNoAdjacent(void)
{
  int result[6];
  result[0] = rand() % 49 + 1;

  for (int i = 1; i < 6; ++i)
  {
    int newNum;

    do
    {
      newNum = rand() % 49 + 1;
    } while (newNum == result[i - 1]);

    result[i] = newNum;
  }

  cout << "6 out of 49 (with repetitions but not adjacent): ";

  for (int i = 0; i < 6; ++i)
  {
    cout << result[i] << " ";
  }

  cout << endl;
}
void drawWithoutRepetition(void)
{
  int numbers[49];

  for (int i = 0; i < 49; ++i)
  {
    numbers[i] = i + 1;
  }

  for (int i = 48; i > 0; --i)
  {
    int random = rand() % (i + 1);
    int temp = numbers[i];
    numbers[i] = numbers[random];
    numbers[random] = temp;
  }

  cout << "6 out of 49 (without repetitions): ";

  for (int i = 0; i < 6; ++i)
  {
    cout << numbers[i] << " ";
  }

  cout << endl;
}
void task8(void)
{
  drawWithRepetition();
  drawWithRepetitionNoAdjacent();
  drawWithoutRepetition();
}

bool XOR(int a, int b) { return (a & ~b) | (~a & b); }
void task9(void)
{
  const int length = 100;
  int numbers[length];
  init_array(numbers, length);

  for (int i = 0; i < length; i++)
  {
    int random1 = rand() % (i + 1);
    int random2 = rand() % (i + 1);

    cout << "XOR for " << numbers[random1] << " and for " << numbers[random2]
         << ": " << XOR(numbers[random1], numbers[random2]) << endl;
  }
}

void init_array2d(int numbers[LENGTH][LENGTH], int range = 1000,
                  int firstLength = LENGTH, int secondLength = LENGTH)
{
  for (int i = 0; i < firstLength; i++)
  {
    for (int j = 0; j < secondLength; j++)
    {
      int random = rand() % range;
      numbers[i][j] = random;
    }
  }
}

void print_array2d(int numbers[LENGTH][LENGTH], int firstLength = LENGTH,
                   int secondLength = LENGTH)
{
  for (int i = 0; i < firstLength; i++)
  {
    for (int j = 0; j < secondLength; j++)
    {
      cout << numbers[i][j] << " ";
    }
    cout << endl;
  }
}

void task12a(void)
{
  int array1[LENGTH][LENGTH];
  int array2[LENGTH][LENGTH];

  init_array2d(array1);

  cout << "First array: " << endl;
  print_array2d(array1);

  for (int i = 0; i < LENGTH; i++)
  {
    for (int j = 0; j < LENGTH; j++)
    {
      array2[i][j] = array1[j][i];
    }
  }

  cout << endl
       << "Second array: " << endl;
  print_array2d(array2);
}

void task13(void)
{
  int numbers[LENGTH][LENGTH];

  init_array2d(numbers, 100, LENGTH);

  for (int i = 0; i < LENGTH; i++)
  {
    numbers[i][i] = i;
  }

  print_array2d(numbers);
}

void task14(void)
{
  int numbers[LENGTH][LENGTH];

  init_array2d(numbers, 100, LENGTH);

  for (int i = LENGTH - 1, j = 0; i >= 0; i--, j++)
  {
    numbers[j][i] = i;
  }

  print_array2d(numbers);
}

void task15(void)
{
  int numbers[LENGTH][LENGTH];

  init_array2d(numbers, 10, LENGTH);

  cout << "Before" << endl;
  print_array2d(numbers);

  for (int i = 0; i < LENGTH; i++)
  {
    for (int j = 2; j < LENGTH; j++)
    {
      int temp = numbers[i][j];
      numbers[i][j] = char(178);
    }

    numbers[i][0] = i;
    numbers[i][1] = pow(numbers[i][1], 2);
  }

  cout << endl
       << "After" << endl;
  print_array2d(numbers);
}

void task18(void)
{
  int numbers[LENGTH][LENGTH][LENGTH];

  for (int i = 0; i < LENGTH; i++)
  {
    for (int j = 0; j < LENGTH; j++)
    {
      for (int k = 0; k < LENGTH; k++)
      {
        int random = rand() % 100;
        numbers[i][j][k] = random;
      }
    }
  }

  for (int i = 0; i < LENGTH; i++)
  {
    for (int j = 0; j < LENGTH; j++)
    {
      for (int k = 0; k < LENGTH; k++)
      {
        cout << numbers[i][j][k] << " ";
      }

      cout << endl;
    }

    cout << endl;
  }
}

void removeCharacter(char *str, char charToRemove)
{
  int length = strlen(str);
  int j = 0;

  for (int i = 0; i < length; i++)
  {
    if (str[i] != charToRemove)
    {
      str[j++] = str[i];
    }
  }

  str[j] = '\0';
}
void task20(void)
{
  char str[] = "hello world";
  char charToRemove = 'l';

  cout << "Original string: " << str << endl;

  removeCharacter(str, charToRemove);
  cout << "String after removing '" << charToRemove << "': " << str << endl;
}

void appendString(char *destination, const char *source,
                  size_t destinationCapacity)
{
  int destLen = strlen(destination);
  int sourceLen = strlen(source);

  if (destLen + sourceLen + 1 > destinationCapacity)
  {
    cout << "Error: Not enough space in destination array." << endl;
    return;
  }

  for (int i = 0; i <= sourceLen; ++i)
  {
    destination[destLen + i] = source[i];
  }
}
void task21(void)
{
  const int destinationCapacity = 50;
  char destination[destinationCapacity] = "Hello";
  const char *source = " World!";

  cout << "Original destination: " << destination << endl;
  cout << "Source: " << source << endl;

  appendString(destination, source, destinationCapacity);

  cout << "After appending: " << destination << endl;
}

int main(void)
{
  srand(time(NULL));

  cout << "Task4!" << endl;
  task4();

  cout << "Task6!" << endl;
  task6();

  cout << "Task7!" << endl;
  task7();

  cout << "Task8!" << endl;
  task8();

  cout << "Task9!" << endl;
  task9();

  cout << "Task12a!" << endl;
  task12a();

  cout << "Task13!" << endl;
  task13();

  cout << "Task14!" << endl;
  task14();

  cout << "Task15!" << endl;
  task15();

  cout << "Task18!" << endl;
  task18();

  cout << "Task20!" << endl;
  task20();

  cout << "Task21!" << endl;
  task21();
}
