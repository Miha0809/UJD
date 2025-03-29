public class Kruskal
{
    public static List<Edge> FindMST(int vertices, List<Edge> edges)
    {
        edges.Sort();
        var dsu = new DisjointSetUnion(vertices);
        var mst = new List<Edge>();

        foreach (var edge in edges)
        {
            if (dsu.Find(edge.From) != dsu.Find(edge.To))
            {
                mst.Add(edge);
                dsu.Union(edge.From, edge.To);
            }
        }

        return mst;
    }
}