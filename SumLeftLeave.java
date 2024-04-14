package LeetCode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SumLeftLeave {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
    
    private int dfs(TreeNode node, boolean isLeftChild) {
        if (node == null) {
            return 0;
        }
        
        if (node.left == null && node.right == null && isLeftChild) {
            return node.val; // Leaf node and left child
        }
        
        int leftSum = dfs(node.left, true); 
        int rightSum = dfs(node.right, false); 
        
        return leftSum + rightSum; 
    }

    public static void main(String[] args) {
        SumLeftLeave solution = new SumLeftLeave();

       
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.sumOfLeftLeaves(root1));
        TreeNode root2 = new TreeNode(1);
        System.out.println(solution.sumOfLeftLeaves(root2));
    }
}
