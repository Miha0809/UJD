class Graph
{
    private int vertices;
    private List<int>[] adjList;

    public Graph(int vertices)
    {
        this.vertices = vertices;
        adjList = new List<int>[vertices];

        for (int i = 0; i < vertices; i++)
        {
            adjList[i] = new List<int>();
        }
    }

    public void AddEdge(int u, int v)
    {
        adjList[u].Add(v);
        adjList[v].Add(u);
    }

    public void RemoveEdge(int u, int v)
    {
        adjList[u].Remove(v);
        adjList[v].Remove(u);
    }

    public void FleuryAlgorithm(int startVertex)
    {
        int u = startVertex;

        while (adjList[u].Count > 0)
        {
            int v = adjList[u][0];

            if (IsValidNextEdge(u, v))
            {
                Console.Write(u + " -> ");
                RemoveEdge(u, v);
                u = v;
            }
        }

        Console.WriteLine(u);
    }

    private bool IsValidNextEdge(int u, int v)
    {
        if (adjList[u].Count == 1)
        {
            return true;
        }

        bool[] visited = new bool[vertices];
        int count1 = DFSCount(u, visited);

        RemoveEdge(u, v);
        visited = new bool[vertices];
        int count2 = DFSCount(u, visited);

        AddEdge(u, v);

        return (count1 > count2) ? false : true;
    }

    private int DFSCount(int v, bool[] visited)
    {
        visited[v] = true;
        int count = 1;

        foreach (int adj in adjList[v])
        {
            if (!visited[adj])
            {
                count += DFSCount(adj, visited);
            }
        }

        return count;
    }
}
