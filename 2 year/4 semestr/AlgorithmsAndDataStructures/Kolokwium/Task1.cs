public class Task1
{
  public static void Init()
  {
    // Punkt 1
    int[] numbers = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    int[] numbersForInsert = (int[])numbers.Clone();
    int[] numbersForSelect = (int[])numbers.Clone();
    int[] numbersForQuick = (int[])numbers.Clone();

    Console.WriteLine("Basic array");
    Show(numbers);

    Console.WriteLine("\nSelectSort");
    var startSelect = DateTime.UtcNow;
    SelectSort(numbersForSelect);
    var endSelect = DateTime.UtcNow;
    Show(numbersForSelect);

    Console.WriteLine("\nInsertSort");
    var startInsert = DateTime.UtcNow;
    InsertSort(numbersForInsert);
    var endInsert = DateTime.UtcNow;
    Show(numbersForInsert);

    Console.WriteLine("\nQuickSort");
    var startQuick = DateTime.UtcNow;
    QuickSort(numbersForQuick, numbersForQuick.Length - 1);
    var endQuick = DateTime.UtcNow;
    Show(numbersForQuick);

    // Punkt 2
    Console.WriteLine("\nTime select sort: " + (endSelect - startSelect));
    Console.WriteLine("\nTime insert sort: " + (endInsert - startInsert));
    Console.WriteLine("\nTime quick sort: " + (endQuick - startQuick));
  }

  private static void Show(int[] numbers)
  {
    foreach (var number in numbers)
    {
      Console.Write(number + " ");
    }

    Console.WriteLine();
  }

  private static void SelectSort(int[] numbers)
  {
    for (int i = 0; i < numbers.Length; i++)
    {
      var minIndex = MinIndex(numbers, i);
      (numbers[i], numbers[minIndex]) = (numbers[minIndex], numbers[i]);
    }
  }

  private static int MinIndex(int[] numbers, int start)
  {
    int min = int.MaxValue;
    int minIndex = 0;

    for (int i = start; i < numbers.Length; i++)
    {
      if (numbers[i] < min)
      {
        min = numbers[i];
        minIndex = i;
      }
    }

    if (minIndex < start)
    {
      return start;
    }

    return minIndex;
  }

  private static void InsertSort(int[] numbers)
  {
    for (int i = 1; i < numbers.Length; ++i)
    {
      int key = numbers[i];
      int j = i - 1;

      while (j >= 0 && numbers[j] > key)
      {
        numbers[j + 1] = numbers[j];
        j = j - 1;
      }

      numbers[j + 1] = key;
    }
  }

  private static int[] QuickSort(int[] letters, int length, int leftIndex = 0)
  {
    var left = leftIndex;
    var right = length;
    var pivot = letters[leftIndex];

    while (left <= right)
    {
      while (letters[left] < pivot)
      {
        left++;
      }

      while (letters[right] > pivot)
      {
        right--;
      }

      if (left <= right)
      {
        (letters[left], letters[right]) = (letters[right], letters[left]);
        left++;
        right--;
      }
    }

    if (leftIndex < right)
    {
      QuickSort(letters, right, leftIndex);
    }

    if (left < length)
    {
      QuickSort(letters, length, left);
    }

    return letters;
  }
}
