public class HamiltonianCycle(int[,] graph)
{
    private readonly int V = graph.GetLength(0);
    private readonly int[,] graph = graph;
    private int minPathWeight = int.MaxValue;
    private int[]? bestPath;

    public void BruteForce()
    {
        int[] path = Enumerable.Range(0, V).ToArray();
        Permute(path, 1);
    }

    private void Permute(int[] path, int l)
    {
        if (l == V - 1)
        {
            int currentWeight = CalculateWeight(path);
            if (currentWeight < minPathWeight)
            {
                minPathWeight = currentWeight;
                bestPath = (int[])path.Clone();
            }
        }
        else
        {
            for (int i = l; i < V; i++)
            {
                Swap(ref path[l], ref path[i]);
                Permute(path, l + 1);
                Swap(ref path[l], ref path[i]);
            }
        }
    }

    private int CalculateWeight(int[] path)
    {
        int weight = 0;
        for (int i = 0; i < V - 1; i++)
        {
            weight += graph[path[i], path[i + 1]];
        }
        weight += graph[path[V - 1], path[0]];
        return weight;
    }

    private void Swap(ref int a, ref int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    public override string ToString()
    {
        return $"Brute-Force Algorithm:\n" +
               $"Minimum Weight: {minPathWeight}\n" +
               $"Path: {string.Join(" -> ", bestPath!)} -> {bestPath![0]}";
    }
}
