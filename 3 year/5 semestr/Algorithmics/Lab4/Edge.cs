public class Edge : IComparable<Edge>
{
    public int From { get; set;}
    public int To { get; set; }
    public int Weight { get; set; }

    public Edge(int from, int to, int weight)
    {
        From = from;
        To = to;
        Weight = weight;
    }

    public int CompareTo(Edge other)
    {
        return Weight.CompareTo(other.Weight);
    }

    public override string ToString()
    {
        return $"Edge({From}, {To}, {Weight})";
    }
}