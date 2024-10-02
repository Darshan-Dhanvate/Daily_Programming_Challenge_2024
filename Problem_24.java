/*
Problem : Lowest Common Ancestor (LCA) in a Binary Tree
You are given a binary tree and two distinct nodes within the tree. 
Your task is to find the lowest common ancestor (LCA) of these two nodes. 
The LCA of two nodes p and q is defined as the lowest node in the tree that 
has both p and q as descendants (where we allow a node to be a descendant of itself).

Input : root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], p = 5, q = 1

Output : 3
*/

// Definition for a binary tree node.
package problems;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) { 
        val = x; 
    }
}

class Problem_24 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, or we find p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively find LCA in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If left is null, return right (LCA is in the right subtree)
        if (left == null) {
            return right;
        }
        // If right is null, return left (LCA is in the left subtree)
        else if (right == null) {
            return left;
        }
        // If both left and right are not null, root is the LCA
        else {
            return root;
        }
    }

    public static void main(String[] args) {
    	Problem_24 obj = new Problem_24();
        
        // Building the tree: [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        
        // Test case: Find LCA of nodes 5 and 1
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1
        
        TreeNode lca = obj.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 5 and 1 is: " + lca.val); // Expected output: 3
    }
}

