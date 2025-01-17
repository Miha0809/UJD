public class Task2
{
  public static void Init()
  {
    int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    const int searchNumber = 5;

    Console.WriteLine("\bBad find");
    Find1(numbers, searchNumber);

    Console.WriteLine("\n+- find");
    var results2 = Find2(numbers, searchNumber);
    Console.WriteLine(results2[0] + " + " + results2[1]);

    Console.WriteLine("\nGood");
    Console.WriteLine(Find3(numbers, searchNumber));
  }

  // Punk 1
  private static void Find1(int[] numbers, int searchNumber)
  {
    int count = 1;

    for (int i = 0; i < numbers.Length; i++)
    {
      for (int j = i; j < numbers.Length; j++)
      {
        if (numbers[i] + numbers[j] == searchNumber)
        {
          Console.WriteLine(count + ") " + numbers[i] + " + " + numbers[j]);
          count++;
        }
      }
    }
  }

  // Punkt 2
  private static int[] Find2(int[] numbers, int searchNumber)
  {
    Array.Sort(numbers);

    int left = 0;
    int right = numbers.Length - 1;

    while (left < right)
    {
      int suma = numbers[left] + numbers[right];

      if (suma == searchNumber)
      {
        return new int[] { numbers[left], numbers[right] };
      }

      if (suma < searchNumber)
      {
        left--;
      }
      else
      {
        right--;
      }
    }

    return new int[] { int.MinValue, int.MinValue };
  }

  // Punk3
  public static (int, int)? Find3(int[] numbers, int searchNumber)
  {
    HashSet<int> seen = new HashSet<int>();

    foreach (var num in numbers)
    {
      int complement = searchNumber - num;

      if (seen.Contains(complement))
      {
        return (complement, num);
      }

      seen.Add(num);
    }

    return null;
  }
}
