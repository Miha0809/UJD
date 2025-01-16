using Lab1.Interfaces;

class GrapthAdjList : IItemManager<Node>
{
    private List<Node> _edges = new();

    void IItemManager<Node>.AddEdge(Node master, Node neighborhood)
    {
        var edge = new Node(master.Value, neighborhood);

        if (!_edges.Contains(edge))
        {
            _edges.Add(edge);
        }
    }

    void IItemManager<Node>.RemoveEdge(Node master, Node neighborhood)
    {
        var edge = new Node(master.Value, neighborhood);

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
