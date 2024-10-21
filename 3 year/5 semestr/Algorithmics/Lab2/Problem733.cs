public class Problem733
{
    public int[][] FloodFill(int[][] image, int sr, int sc, int color)
    {
        if (image[sr][sc] == color)
        {
            return image;
        }

        Queue<int> queue = new Queue<int>();
        image[sr][sc] = color;
        queue.Enqueue(image[sr][sc]);

        while (queue.Count > 0)
        {
            var currentColor = queue.Dequeue();

            for (var i = 0; i < image.Length; i++)
            {
                for (var j = 0; j < image[i].Length; j++)
                {
                    if (
                        sr < 0
                        || sc < 0
                        || sr >= image.Length
                        || sc >= image[0].Length
                        || image[sr][sc] != color
                    )
                    {
                        break;
                    }

                    if (image[i][j] == sc)
                    {
                        image[i][j] = color;
                        queue.Enqueue(image[i][j]);
                    }
                }
            }
        }

        return image;
    }
}
