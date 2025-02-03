public class NearestNeighbor(int[,] graph)
{
    private readonly int V = graph.GetLength(0);
    private readonly int[,] graph = graph;
    private readonly int[] path = new int[graph.GetLength(0) + 1];
    private int pathWeight = 0;

    public void FindHamiltonianCycle(int startVertex)
    {
        bool[] visited = new bool[V];

        int currentVertex = startVertex;
        visited[currentVertex] = true;
        path[0] = currentVertex;

        for (int i = 1; i < V; i++)
        {
            int nextVertex = -1;
            int minWeight = int.MaxValue;

            for (int j = 0; j < V; j++)
            {
                if (!visited[j] && graph[currentVertex, j] < minWeight)
                {
                    minWeight = graph[currentVertex, j];
                    nextVertex = j;
                }
            }

            path[i] = nextVertex;
            visited[nextVertex] = true;
            pathWeight += minWeight;
            currentVertex = nextVertex;
        }

        path[V] = startVertex;
        pathWeight += graph[currentVertex, startVertex];
    }

    public override string ToString()
    {
        return $"Nearest Neighbor Algorithm:\n" +
               $"Total Weight: {pathWeight}\n" +
               $"Path: {string.Join(" -> ", path)}";
    }
}
