namespace Lab1.Interfaces;

public interface IItemManager : IShow
{
    void AddEdge(int i, int j);
    void RemoveEdge(int i, int j);
}
