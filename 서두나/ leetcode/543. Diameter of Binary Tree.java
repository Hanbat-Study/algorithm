/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        recursive(root);       
        return ans;
    }

    public int recursive(TreeNode root){
        if(root == null){
            return 0;
        }

        int a = recursive(root.left);
        int b = recursive(root.right);

        ans = Math.max(ans, a + b);

        return Math.max(a, b) + 1;
    }
}
