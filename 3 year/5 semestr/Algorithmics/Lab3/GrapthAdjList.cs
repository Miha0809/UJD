class GrapthAdjList
{
    private Stack<Node> order = new();

    public void DFS(Node grapth)
    {
        grapth.IsVerified = true;

        foreach (var item in grapth.Neighbors)
        {
            if (!item.IsVerified)
            {
                DFS(item);
            }
        }

        order.Push(grapth);
    }

    public override string ToString()
    {
        foreach (var edge in order)
        {
            Console.WriteLine(edge);
        }

        return "";
    }
}