public class BFS
{
    public List<Node> Edges = new();

    public void Search()
    {
        foreach (var item in Edges)
        {
            item.isVerified = true;

            foreach (var neighbor in item.Neighbors)
            {
                neighbor.isVerified = true;
            }
        }
    }

    public void AddEdge(Node master, Node neighborhood)
    {
        var edge = new Node(master.Value, neighborhood);

        if (!Edges.Contains(edge))
        {
            Edges.Add(edge);
        }
    }

    public void RemoveEdge(Node master, Node neighborhood)
    {
        var edge = new Node(master.Value, neighborhood);

        if (Edges.Contains(edge))
        {
            Edges.Remove(edge);
        }
    }

    public override string ToString()
    {
        foreach (var edge in Edges)
        {
            Console.WriteLine(edge);
        }

        return "";
    }
}
