// 1161. Maximum Level Sum of a Binary Tree

// Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

// Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

// Example 1:

// Input: root = [1,7,0,7,-8,null,null]
// Output: 2
// Explanation: 
// Level 1 sum = 1.
// Level 2 sum = 7 + 0 = 7.
// Level 3 sum = 7 + -8 = -1.
// So we return the level with the maximum sum which is level 2.
// Example 2:

// Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
// Output: 2

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -10^5 <= Node.val <= 10^5

class Solution {
  public int maxLevelSum(TreeNode root) {
    long maxSum = Long.MIN_VALUE;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int maxSumLevel = 1;
    int curLevel = 1;
    while (!q.isEmpty()) {
      int size = q.size();
      long sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        sum += node.val;
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      if (sum > maxSum) {
        maxSum = sum;
        maxSumLevel = curLevel;
      }
      curLevel++;
    }
    return maxSumLevel;
  }

}