/// <summary>
/// Точкаh
/// </summary>
public class Node<T>
{
    public T Value { get; set; }

    /// <summary>
    /// Сусіди.
    /// </summary>
    public List<Node<T>> Neighborhood { get; set; }

    public override string ToString()
    {
        return $"\nValue: {Value}\n" + $"Neighborhood: {Neighborhood}\n";
    }
}
