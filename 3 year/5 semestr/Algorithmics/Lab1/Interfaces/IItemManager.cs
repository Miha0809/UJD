namespace Lab1.Interfaces;

public interface IItemManager<T>
{
    void AddEdge(T master, T neighborhood);
    void RemoveEdge(T master, T neighborhood);
}
