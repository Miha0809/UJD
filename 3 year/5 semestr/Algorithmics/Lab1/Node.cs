public class Node
{
    public int Value { get; set; }
    public List<Node> Neighbors { get; set; } = new();

    public Node(int value)
    {
        Value = value;
    }

    public Node(int value, Node neighbor)
    {
        Value = value;
        Neighbors.Add(neighbor);
    }

    public override string ToString()
    {
        Console.Write($"\nValue: {Value}");
        Neighbors.ForEach(value => Console.WriteLine(value));

        return "";
    }
}
