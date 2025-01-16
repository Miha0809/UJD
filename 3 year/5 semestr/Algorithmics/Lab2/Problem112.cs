public class TreeNode
{
    public int Value;
    public TreeNode? Left = null;
    public TreeNode? Right = null;

    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
    {
        this.Value = val;
        this.Left = left;
        this.Right = right;
    }
}

public class Problem112
{
    public bool HasPathSum(TreeNode root, int targetSum)
    {
        if (root is null)
        {
            return false;
        }
        else if (root.Left is null && root.Right is null)
        {
            return root.Value == targetSum;
        }

        int newTargetSum = targetSum - root.Value;
        return HasPathSum(root.Left, newTargetSum) || HasPathSum(root.Right, newTargetSum);
    }
}
