/// <summary>
/// [TODO:description]
/// </summary>
public static class GraphAdjList
{
    public static void Add(this Node master, Node neighborhood)
    {
        master.Neighborhood.Add(neighborhood);
    }

    public static void Remove(this Node master, Node neighborhood)
    {
        master.Neighborhood.Remove(neighborhood);
    }

    public static void Display() { }
}
