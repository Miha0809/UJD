// Task1
var edges = new (int, int)[]
{
    (0, 1),
    (1, 2),
    (3, 4),
    (5, 6),
    (3, 5)
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

// Task2
var edges2 = new List<Edge>
{
    new Edge(0, 1, 4),
    new Edge(1, 2, 2),
    new Edge(3, 4, 6),
    new Edge(5, 6, 7),
    new Edge(3, 5, 3)
};

var mst = Kruskal.FindMST(size, edges2);

Console.WriteLine("\nMST:");

foreach (var edge in mst)
{
    Console.WriteLine(edge);
}