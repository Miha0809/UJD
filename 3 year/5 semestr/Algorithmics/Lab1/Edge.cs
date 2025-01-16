public class Edge
{
    public int A { get; set; }
    public int B { get; set; }

    public Edge(int a, int b)
    {
        A = a;
        B = b;
    }

    public override bool Equals(object? obj)
    {
        if (obj == null || GetType() != obj.GetType())
        {
            return false;
        }

        Edge other = (Edge)obj;
        return A == other.A && B == other.B;
    }

    public override int GetHashCode()
    {
        return A.GetHashCode() ^ B.GetHashCode();
    }

    public override string ToString() => $"A: {A}\n" + $"B: {B}\n";
}
