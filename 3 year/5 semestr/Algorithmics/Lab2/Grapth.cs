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
}
