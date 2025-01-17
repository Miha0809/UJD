#include <iostream>

using namespace std;

// Task1

struct Point
{
public:
  int x;
  int y;
};

struct Square
{
public:
  int x1, x2;
  int y1, y2;
};

bool pointInSquare(Point p, Square s)
{
  return (p.x >= s.x1 && p.x <= s.x2 && p.y >= s.y1 && p.y <= s.y2);
}

Square normalizeSquare(Square s)
{
  Square normalizedSquare;

  normalizedSquare.x1 = min(s.x1, s.x2);
  normalizedSquare.y1 = min(s.y1, s.y2);
  normalizedSquare.x2 = max(s.x1, s.x2);
  normalizedSquare.y2 = max(s.y1, s.y2);

  return normalizedSquare;
}

void task1(void)
{
  Point p = {3, 4};
  Square s = {1, 1, 5, 5};

  if (pointInSquare(p, s))
  {
    cout << "The point is inside the square." << endl;
  }
  else
  {
    cout << "The point is not inside the square." << endl;
  }

  Square normalized = normalizeSquare(s);
  cout << "After normalization, the coordinates of the square are ("
       << normalized.x1 << ", " << normalized.y1 << ") and (" << normalized.x2
       << ", " << normalized.y2 << ")" << endl;
}

// Task2

struct Triangle
{
public:
  double side1;
  double side2;
  double side3;
};

double calculatePerimeter(Triangle t) { return t.side1 + t.side2 + t.side3; }

void task2(void)
{
  Triangle triangle;

  cout << "Enter the length of the 1 side of the triangle: ";
  cin >> triangle.side1;

  cout << "Enter the length of the 2 side of the triangle: ";
  cin >> triangle.side2;

  cout << "Enter the length of the 3 side of the triangle: ";
  cin >> triangle.side3;

  double perimeter = calculatePerimeter(triangle);
  cout << "The perimeter of the triangle is: " << perimeter << endl;
}

// Task3

struct Data
{
public:
  int integer;
  int *intPointer;
  char *charPointer;
  char *charArrayPointer;
  std::string str;
};

void modifyDataByValue(Data data)
{
  data.integer *= 2;
  *(data.intPointer) *= 2;
  *(data.charPointer) = 'X';
  *(data.charArrayPointer + 1) = 'Y';
  data.str = "Modified by value";
}

void modifyDataByPointer(Data *data)
{
  data->integer *= 3;
  *(data->intPointer) *= 3;
  *(data->charPointer) = 'Z';
  *(data->charArrayPointer + 2) = 'W';
  data->str = "Modified by pointer";
}

void task3(void)
{
  Data data;
  int intValue = 10;
  char charValue = 'A';
  char charArray[] = "Hello";

  data.integer = 5;
  data.intPointer = &intValue;
  data.charPointer = &charValue;
  data.charArrayPointer = charArray;
  data.str = "Original";

  cout << "Before calling functions:\n";
  cout << "Integer: " << data.integer << endl;
  cout << "Integer pointed by intPointer: " << *(data.intPointer) << endl;
  cout << "Character pointed by charPointer: " << *(data.charPointer) << endl;
  cout << "Character in charArrayPointer: " << data.charArrayPointer[1] << endl;
  cout << "String: " << data.str << endl
       << endl;

  modifyDataByValue(data);

  cout << "After calling modifyDataByValue:\n";
  cout << "Integer: " << data.integer << endl;
  cout << "Integer pointed by intPointer: " << *(data.intPointer) << endl;
  cout << "Character pointed by charPointer: " << *(data.charPointer) << endl;
  cout << "Character in charArrayPointer: " << data.charArrayPointer[1] << endl;
  cout << "String: " << data.str << endl
       << endl;

  modifyDataByPointer(&data);

  cout << "After calling modifyDataByPointer:\n";
  cout << "Integer: " << data.integer << endl;
  cout << "Integer pointed by intPointer: " << *(data.intPointer) << endl;
  cout << "Character pointed by charPointer: " << *(data.charPointer) << endl;
  cout << "Character in charArrayPointer: " << data.charArrayPointer[1] << endl;
  cout << "String: " << data.str << endl;
}

// Task4

struct NetworkInfo
{
public:
  bool inRange : 1;
  unsigned int mask : 32;
  unsigned int ipAddress : 32;
};

void task4(void)
{
  NetworkInfo info;
  info.inRange = (7 >= -3 && 7 < 7) || (7 >= 7 && 7 < 21);

  cout << "Is 7 within the ranges <-3..7) or <7..21>: "
       << (info.inRange ? "Yes" : "No") << endl;

  // 2- Set the IP address mask to 24 bits, provide the subnet number and host
  // for the IP address 192.168.0.130 using hexadecimal notation
  info.mask = 0xFFFFFF00;      // Mask: 255.255.255.0 (24 bits)
  info.ipAddress = 0xC0A80082; // IP Address: 192.168.0.130

  unsigned int subnet = info.ipAddress & info.mask;
  unsigned int host = info.ipAddress & ~info.mask;

  cout << "Subnet: " << hex << subnet << ", Host: " << host << endl;
}

// Task5

union IntToBytes
{
public:
  int integerValue;
  unsigned char byteValue[4];
};

void task5(void)
{
  IntToBytes data;
  data.integerValue = 16909060;

  for (int i = 0; i < 4; i++)
  {
    cout << "Byte " << i + 1 << ": " << (int)data.byteValue[i] << endl;
  }
}

// Task6

union IntToCharArray
{
public:
  unsigned short int shortValue[2];
  char charArray[4];
};

void task6(void)
{
  IntToCharArray data;
  data.shortValue[0] = 65;

  for (int i = 0; i < 4; i++)
  {
    cout << "Byte " << i + 1 << ": " << (int)data.charArray[i] << endl;
  }
}

// Task7

union MixedData
{
public:
  int intValue1;
  float floatValue;
  int intValue2;
  char charValue;
};

void task7(void)
{
  MixedData data;

  cout << "Enter an integer for intValue1: ";
  cin >> data.intValue1;
  cout << "Values after setting intValue1:\n";
  cout << "intValue1: " << data.intValue1 << endl;
  cout << "floatValue: " << data.floatValue << endl;
  cout << "intValue2: " << data.intValue2 << endl;
  cout << "charValue: " << data.charValue << endl;
  cout << endl;

  cout << "Enter a float for floatValue: ";
  cin >> data.floatValue;
  cout << "Values after setting floatValue:\n";
  cout << "intValue1: " << data.intValue1 << endl;
  cout << "floatValue: " << data.floatValue << endl;
  cout << "intValue2: " << data.intValue2 << endl;
  cout << "charValue: " << data.charValue << endl;
  cout << endl;

  cout << "Enter an integer for intValue2: ";
  cin >> data.intValue2;
  cout << "Values after setting intValue2:\n";
  cout << "intValue1: " << data.intValue1 << endl;
  cout << "floatValue: " << data.floatValue << endl;
  cout << "intValue2: " << data.intValue2 << endl;
  cout << "charValue: " << data.charValue << endl;
  cout << endl;

  cout << "Enter a character for charValue: ";
  cin >> data.charValue;
  cout << "Values after setting charValue:\n";
  cout << "intValue1: " << data.intValue1 << endl;
  cout << "floatValue: " << data.floatValue << endl;
  cout << "intValue2: " << data.intValue2 << endl;
  cout << "charValue: " << data.charValue << endl;
}

int main(void)
{
  cout << "Task1!" << endl;
  task1();

  cout << "Task2!" << endl;
  task2();

  cout << "Task3!" << endl;
  task3();

  cout << "Task4!" << endl;
  task4();

  cout << "Task5!" << endl;
  task5();

  cout << "Task6!" << endl;
  task6();

  cout << "Task7!" << endl;
  task7();

  return 0;
}
