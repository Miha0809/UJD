#include <iostream>

using namespace std;

void zadanie2()
{
  // Task1
  int num1[] = {95, 35, 27, 17, 93, 16, 30, 10, 83, 68, 82, 20, 32, 23, 14,
                95, 85, 84, 57, 3, 77, 34, 58, 70, 47, 91, 38, 76, 54, 28,
                64, 49, 63, 43, 18, 56, 11, 49, 67, 95, 69, 1, 67, 54, 24,
                33, 1, 61, 17, 58, 64, 46, 44, 74, 16, 92, 17, 6, 68, 71,
                34, 84, 72, 50, 79, 90, 6, 90, 91, 25, 37, 13, 26, 5, 67,
                2, 90, 68, 63, 8, 79, 27, 6, 75, 1, 75, 67, 18, 81, 87,
                41, 68, 23, 13, 18, 2, 56, 76, 45, 47};
  int num2[] = {95, 35, 27, 17, 93, 16, 30, 10, 83, 68, 82, 20, 32, 23, 14,
                95, 85, 84, 57, 3, 77, 34, 58, 70, 47, 91, 38, 76, 54, 28,
                64, 49, 63, 43, 18, 56, 11, 49, 67, 95, 69, 1, 67, 54, 24,
                33, 1, 61, 17, 58, 64, 46, 44, 74, 16, 92, 17, 6, 68, 71,
                34, 84, 72, 50, 79, 90, 6, 90, 91, 25, 37, 13, 26, 5, 67,
                2, 90, 68, 63, 8, 79, 27, 6, 75, 1, 75, 67, 18, 81, 87,
                41, 68, 23, 13, 18, 2, 56, 76, 45, 47};

  const int length = end(num1) - begin(num1);
  int sumaArrays[length];

  for (int i = 0; i < length; i++)
  {
    sumaArrays[i] = (num1[i] + num2[i]);
  }

  long suma = 0;

  for (int i = 0; i < length; i++)
  {
    if (i % 10 == 0)
    {
      cout << sumaArrays[i] << " ";
      suma += sumaArrays[i];
    }
  }

  for (int i = 0; i < length; i += 10)
  {
  }

  cout << endl
       << "Suma: " << suma << endl;

  // Task2
  char word[] = "Napis";
  int codes[5];
  long sumaCodes = 0;

  for (int i = 0; i < 5; i++)
  {
    codes[i] = (int)word[i];
    sumaCodes += codes[i];
  }

  cout << "Suma: " << sumaCodes << endl;
}

void zadanie3()
{
  int codes[] = {
      197, 203, 240, 233, 33, 19, 195, 210, 66, 98, 76, 221, 113, 240,
      28, 57, 245, 134, 94, 28, 57, 121, 121, 6, 225, 107, 213, 42,
      110, 156, 56, 159, 109, 46, 142, 245, 65, 190, 205, 233, 140, 31,
      56, 3, 123, 187, 61, 118, 173, 7, 248, 231, 128, 221, 237, 103,
      78, 52, 146, 40, 60, 202, 199, 21, 101, 194, 16, 18, 134, 221,
      2, 126, 104, 160, 129, 227, 97, 42, 197, 21, 151, 195, 104, 30,
      167, 193, 235, 97, 245, 233, 138, 157, 38, 87, 178, 139, 31, 195,
      157, 17, 18, 11, 143, 123, 172, 125, 202, 121, 19, 150, 244, 171,
      95, 98, 201, 114, 41, 186, 212, 138, 170, 100, 45, 60, 187, 76,
      199, 71, 21, 106, 88, 39, 118, 84, 14, 142, 209, 69, 13, 228,
      71, 8, 149, 18, 208, 202, 133, 102, 139, 95, 92, 161, 195, 240,
      221, 234, 66, 22, 55, 87, 128, 246, 228, 98, 80, 95, 240, 141,
      164, 106, 119, 235, 216, 121, 3, 26, 73, 136, 128, 64, 83, 73,
      225, 130, 63, 48, 115, 129, 70, 22, 68, 51, 120, 148, 149, 52,
      243, 242, 193, 157, 200, 63, 244, 166, 184, 248, 192, 109, 236, 173,
      174, 172, 246, 149, 52, 161, 50, 19, 142, 222, 144, 210, 23, 14,
      108};
  long length = end(codes) - begin(codes);
  int count = 0;

  for (int i = 0; i < length; i++)
  {
    cout << (char)codes[i] << " ";

    if ((int)codes[i] >= 65 && (int)codes[i] <= 90)
    {
      count++;
    }
  }

  cout << endl
       << "Count " << count << endl;
}

int main(void)
{
  // zadanie2();
  zadanie3();

  return 1;
}
