var edges = new (int, int)[]
{
    (0, 1),
    (1, 2),
    (3, 4),
    (5, 6),
    (7, 8)
};

int size = edges.Length * 2;
var dsu = new DisjointSetUnion(size);

foreach (var edge in edges)
{
    dsu.Union(edge.Item1, edge.Item2);
}

Console.WriteLine(dsu.ToString());

for (int i = 0; i < size; i++)
{
    Console.WriteLine($"Element {i} belongs {dsu.Find(i)}");
}
