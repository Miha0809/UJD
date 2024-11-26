public class Node
{
    public int Value { get; set; }
    public bool isVerified { get; set; }
    public List<Node> Neighbors { get; set; } = new();

    public Node() { }

    public Node(int value)
    {
        Value = value;
    }

    public void AddNeighborhood(Node neighborhood)
    {
        if (!Neighbors.Contains(neighborhood))
        {
            this.Neighbors.Add(neighborhood);
        }
    }

    public override string ToString() => $"Value: {Value}\nIsVerified: {isVerified}\n";
}
