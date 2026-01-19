/*
1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
Solved
Topics
premium lock icon
Companies
Hint
Given a m x n matrix mat and an integer threshold, return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.

 

Example 1:


Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
Output: 2
Explanation: The maximum side length of square with sum less than 4 is 2 as shown.
Example 2:

Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
Output: 0
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 300
0 <= mat[i][j] <= 10^4
0 <= threshold <= 10^5

*/

class Solution {
  public int maxSideLength(int[][] mat, int threshold) {
    int n = mat.length;
    int m = mat[0].length;
    int[][] pref = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j == 0)
          pref[i][j] = mat[i][j];
        else
          pref[i][j] = pref[i][j - 1] + mat[i][j];
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int col = j;
        int row = i;
        while (col < m && row < n) {
          int sum = calculateSum(mat, pref, row, col, i, j);
          if (sum > threshold)
            break;
          max = Math.max(max, col - j + 1);
          col++;
          row++;
        }
      }
    }
    return max;
  }

  private int calculateSum(int[][] grid, int[][] pref, int row, int col, int i, int j) {
    int sum = 0;
    for (int y = i; y <= row; y++) {
      sum += pref[y][col] - pref[y][j] + grid[y][j];
    }
    return sum;
  }
}