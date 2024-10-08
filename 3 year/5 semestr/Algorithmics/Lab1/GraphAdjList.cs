using Lab1.Interfaces;

class GrapthAdjList
{
    private List<Node> _righthEdges = new List<Node>();

    public void AddEdge(Node node)
    {
        _righthEdges.Add(node);
    }

    public void Display() { }

    public void RemoveEdge(int i, int j) { }
}
