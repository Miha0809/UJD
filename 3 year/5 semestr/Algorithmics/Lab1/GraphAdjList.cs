using Lab1.Interfaces;

class GrapthAdjList : IItemManager<Node>
{
    public GrapthAdjList() { }

    public void AddEdge(Node master, Node neighborhood)
    {
        if (!master.Neighbors.Contains(neighborhood))
        {
            master.Neighbors.Add(neighborhood);
        }
    }

    public void RemoveEdge(Node master, Node neighborhood)
    {
        if (master.Neighbors.Contains(neighborhood))
        {
            master.Neighbors.Remove(neighborhood);
        }
    }
}
