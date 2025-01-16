using Lab1.Interfaces;

public class GraphEdgeList : IItemManager<int>
{
    private List<Edge> _edges = new();

    void IItemManager<int>.AddEdge(int i, int j)
    {
        var edge = new Edge(i, j);

        if (!_edges.Contains(edge))
        {
            _edges.Add(edge);
        }
    }

    void IItemManager<int>.RemoveEdge(int i, int j)
    {
        var edge = new Edge(i, j);

        if (_edges.Contains(edge))
        {
            _edges.Remove(edge);
        }
    }

    public override string ToString()
    {
        foreach (var edge in _edges)
        {
            Console.WriteLine(edge);
        }

        return "";
    }
}
