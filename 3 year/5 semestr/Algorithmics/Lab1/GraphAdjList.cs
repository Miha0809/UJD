using Lab1.Interfaces;

class GrapthAdjList : IItemManager<Node>
{
    public GrapthAdjList() { }

    public void AddEdge(Node master, Node neighborhood)
    {
        master.Neighbors.Add(neighborhood);
    }

    public void RemoveEdge(Node master, Node neighborhood)
    {
        master.Neighbors.Remove(neighborhood);
    }
}
