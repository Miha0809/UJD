public class DisjointSetUnion
{
    private int[] parent;
    private int[] rank;

    public DisjointSetUnion(int size)
    {
        parent = Enumerable.Range(0, size).Select(n => n).ToArray();
        rank = Enumerable.Range(0, size).Select(n => 0).ToArray();
    }

    public int Find(int value)
    {
        return parent[value] == value ? value : (parent[value] = Find(parent[value]));
    }

    public void Union(int x, int y)
    {
        int rootX = Find(x);
        int rootY = Find(y);

        if (rootX != rootY)
        {
            if (rank[rootX] > rank[rootY])
            {
                parent[rootY] = rootX;
            }
            else if (rank[rootX] < rank[rootY])
            {
                parent[rootX] = rootY;
            }
            else
            {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public override string ToString()
    {
        return $"Parent: {string.Join(", ", parent)}\n" +
               $"Rank: {string.Join(", ", rank)}\n";
    }
}