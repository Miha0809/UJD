public class Grapth
{
    public void BFS(Node start)
    {
        Queue<Node> queue = new Queue<Node>();
        start.isVerified = true;
        queue.Enqueue(start);

        while (queue.Count > 0)
        {
            var currentNode = queue.Dequeue();
            Console.WriteLine(currentNode);

            foreach (var neighbor in currentNode.Neighbors)
            {
                if (!neighbor.isVerified)
                {
                    neighbor.isVerified = true;
                    queue.Enqueue(neighbor);
                }
            }
        }
    }

    public void DFS(Node grapth)
    {
        grapth.isVerified = true;

        foreach (var item in grapth.Neighbors)
        {
            if (!item.isVerified)
            {
                DFS(item);
                Console.WriteLine(item);
            }
        }
    }
}
