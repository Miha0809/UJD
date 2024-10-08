using Lab1.Interfaces;

public class GraphMatrix2 : IItemManager
{
    private bool[,] _points;
    private readonly int _length;

    public GraphMatrix2(int length)
    {
        _points = new bool[length, length];
        _length = length;
    }

    public void AddEdge(int i, int j)
    {
        if (i <= _length && j <= _length)
        {
            _points[i - 1, j - 1] = true;
        }
    }

    public void RemoveEdge(int a, int b)
    {
        bool[,] result = new bool[
            _points.GetLength(0) - ((b - a) + 1),
            _points.GetLength(1) - ((b - a) + 1)
        ];

        for (int i = 0, j = 0; i < _points.GetLength(0); i++)
        {
            if (i >= a && i <= b)
            {
                continue;
            }

            for (int k = 0, u = 0; k < _points.GetLength(1); k++)
            {
                if (k >= a && k <= b)
                {
                    continue;
                }

                result[j, u] = _points[i, k];
                u++;
            }

            j++;
        }

        _points = result;
    }

    public void Display()
    {
        for (int i = 0; i < _points.GetLength(0); i++)
        {
            for (int j = 0; j < _points.GetLength(1); j++)
            {
                Console.Write(_points[i, j] + " ");
            }

            Console.WriteLine();
        }
    }
}
