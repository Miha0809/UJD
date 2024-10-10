using Lab1.Interfaces;

public class GraphMatrix : IItemManager
{
    private bool[,] _points = new bool[0, 0];

    public GraphMatrix() { }

    public void AddEdge(int i, int j)
    {
        int largerNumber = i > j ? i : j;
        var oldArray = _points.Clone() as bool[,];

        InitArray(start: _points.GetLength(0), end: largerNumber);

        if (largerNumber > oldArray?.GetLength(0))
        {
            CopyOldNumbersToNewArray(oldArray);
        }

        _points[i - 1, j - 1] = true;
    }

    private void InitArray(int start, int end)
    {
        for (int i = start; i <= end; i++)
        {
            _points = new bool[i, end];
        }
    }

    private void CopyOldNumbersToNewArray(bool[,] oldArray, int skipRow = -1, int skipColumn = -1)
    {
        for (int i = 0; i < oldArray.GetLength(0); i++)
        {
            for (int j = 0; j < oldArray.GetLength(1); j++)
            {
                if (oldArray[i, j] == true && skipColumn != i && skipRow != j)
                {
                    _points[i, j] = oldArray[i, j];
                }
            }
        }
    }

    public void RemoveEdge(int i, int j)
    {
        try
        {
            _points[i - 1, j - 1] = false;
        }
        catch (System.Exception e)
        {
            Console.WriteLine(e.Message);
            throw;
        }
    }

    public override string ToString()
    {
        for (int i = 0; i < _points.GetLength(0); i++)
        {
            for (int j = 0; j < _points.GetLength(1); j++)
            {
                Console.Write(_points[i, j] + " ");
            }

            Console.WriteLine();
        }

        return "";
    }
}
