// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I use a breadth-first search (BFS) to traverse the tree level by level.
// For each level, I check if both nodes x and y are present. If they are, I check if they are siblings (i.e., if they share the same parent). If they are not siblings and both are found at the same level, they are cousins.

import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) ||
                        (current.left.val == y && current.right.val == x)) {
                        return false;
                    }
                }
                if (current.left != null) {
                    queue.offer(current.left);
                    if (current.left.val == x) foundX = true;
                    if (current.left.val == y) foundY = true;
                }
                if (current.right != null) {
                    queue.offer(current.right);
                    if (current.right.val == x) foundX = true;
                    if (current.right.val == y) foundY = true;
                }
            }
            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }

        return false;
    }
}
