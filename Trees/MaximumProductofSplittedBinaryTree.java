/*
1339. Maximum Product of Splitted Binary Tree

Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.



Example 1:


Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
Example 2:


Input: root = [1,null,2,3,4,null,null,5,6]
Output: 90
Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)


Constraints:

The number of nodes in the tree is in the range [2, 5 * 104].
1 <= Node.val <= 10^4
*/

class Solution {
  int mod = (int) (1e9) + 7;
  long ans = 0;

  public int maxProduct(TreeNode root) {
    long totalSum = calculateTotalSum(root);
    helper(root, totalSum);
    return (int) (ans % mod);

  }

  private long helper(TreeNode node, long totalSum) {
    if (node == null)
      return 0;

    long left = helper(node.left, totalSum);
    long right = helper(node.right, totalSum);

    long curSum = left + right + node.val;

    long remSum = totalSum - curSum;

    long product = (curSum * remSum);

    ans = Math.max(product, ans);

    return curSum;
  }

  private long calculateTotalSum(TreeNode node) {
    if (node == null)
      return 0;

    long left = calculateTotalSum(node.left);
    long right = calculateTotalSum(node.right);

    return left + right + node.val;
  }
}