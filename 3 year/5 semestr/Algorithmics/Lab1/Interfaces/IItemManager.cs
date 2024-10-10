namespace Lab1.Interfaces;

public interface IItemManager<T>
{
    void AddEdge(T i, T j);
    void RemoveEdge(T i, T j);
}
