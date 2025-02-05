Console.WriteLine("Count vertices:");
int vertices = int.Parse(Console.ReadLine());

Graph graph = new Graph(vertices);

Console.WriteLine($"Input edges in the format 'u v' (max number is {vertices - 1}) (empty line = stop):");

while (true)
{
    string line = Console.ReadLine();
    if (string.IsNullOrEmpty(line))
    {
        break;
    }

    string[] parts = line.Split();
    int u = int.Parse(parts[0]);
    int v = int.Parse(parts[1]);

    try
    {
        graph.AddEdge(u, v);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
        continue;
    }
}

int startVertex = 0;

Console.WriteLine("Eulerian Path: ");
graph.FleuryAlgorithm(startVertex);