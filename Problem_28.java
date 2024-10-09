/*
Problem : Check if a Binary Tree is Symmetric
You are given the root of a binary tree. 
Your task is to determine whether the tree is symmetric. 
A binary tree is symmetric if the left and right subtrees 
are mirror images of each other.

Input : [1, 2, 2, 3, 4, 4, 3]

Output : true
*/

package problems;

public class Problem_28 {

    public static void main(String[] args) {
        // Example: [1, 2, 2, 3, 4, 4, 3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));  // Output: true
    }

    // Function to check if the binary tree is symmetric
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;  // An empty tree is symmetric
        }
        return isMirror(root.left, root.right);
    }

    // Helper function to check if two trees are mirror images of each other
    private static boolean isMirror(TreeNode left, TreeNode right) {
        // Base cases
        if (left == null && right == null) {
            return true;  // Both are null, hence symmetric
        }
        if (left == null || right == null) {
            return false;  // One is null and the other is not, hence not symmetric
        }

        // Check if current nodes are equal and their children are mirrors of each other
        return (left.val == right.val) &&
               isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
