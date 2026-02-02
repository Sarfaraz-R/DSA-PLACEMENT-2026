/*
 * Count Subset With Target Sum II

 * Given an array arr[] and an integer k, find the count of subsets whose sum is
 * equals to k.
 * 
 * Note: It is guaranteed that the no of valid subsets will fit within a 32-bit
 * integer.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 3, 2], k = 3
 * Output: 2
 * Explanation: The two subsets whose sum is equals to k are [1, 2] and [3].
 * Input: arr[] = [4, 2, 3, 1, 2], k = 4
 * Output: 3
 * Explanation: The three subsets whose sum is equals to k are [4], [2, 2] and
 * [3, 1].
 * Input: arr[] = [10, 20, 30], k = 25
 * Output: 0
 * Explanation: No subsets exits with sum equals to k.
 * Constraints:
 * 1 ≤ arr.size() ≤ 40
 * -107 ≤ arr[i], k ≤ 107
 * 
 * 
 */

class Solution {
  public int countSubset(int[] arr, int k) {
    int n = arr.length;
    if (k < 0)
      return 0;

    for (int x : arr) {
      if (x < 0)
        return 0;
    }

    long[][] dp = new long[n + 1][k + 1];
    dp[n][k] = 1;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = k; j >= 0; j--) {
        long notTake = dp[i + 1][j];
        long take = 0;
        if (j + arr[i] <= k) {
          take = dp[i + 1][j + arr[i]];
        }
        dp[i][j] = take + notTake;
      }
    }
    return (int) dp[0][0];
  }

}