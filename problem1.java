// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I maintain a variable to keep track of the height of the tree as I traverse it. 
// If the current height is greater than the stored height, I add the node's value to the result list.
// I traverse the right subtree first to ensure that the rightmost nodes are processed first. Then I go to left to keep a track of the elements on left side that appear from the right side view.


import java.util.ArrayList;
import java.util.List;

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
    private int height;
    public List<Integer> rightSideView(TreeNode root) {
        height = -1;
        List<Integer> ans = new ArrayList<>();
        rightView(root, 0, ans);
        return ans;
    }
    public void rightView(TreeNode root, int currHeight, List<Integer> list){
        if(root == null) return;
        if(currHeight>height){
            list.add(root.val);
            height = currHeight;
        }
        rightView(root.right, currHeight+1, list);
        rightView(root.left, currHeight+1, list);
    }
}