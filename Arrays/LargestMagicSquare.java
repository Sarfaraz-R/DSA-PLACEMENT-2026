// 1895. Largest Magic Square

// A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum, and both diagonal sums are all equal. The integers in the magic square do not have to be distinct. Every 1 x 1 grid is trivially a magic square.

// Given an m x n integer grid, return the size (i.e., the side length k) of the largest magic square that can be found within this grid.

// Example 1:

// Input: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
// Output: 3
// Explanation: The largest magic square has a size of 3.
// Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
// - Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
// - Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
// - Diagonal sums: 5+4+3 = 6+4+2 = 12
// Example 2:

// Input: grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
// Output: 2

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// 1 <= grid[i][j] <= 10^6

class Solution {
  public int largestMagicSquare(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    long[][] prefR = new long[n][m];
    long[][] prefC = new long[n][m];
    long[][] prefLD = new long[n][m];
    long[][] prefRD = new long[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        prefR[i][j] = grid[i][j];
        prefC[i][j] = grid[i][j];
        prefLD[i][j] = grid[i][j];
        if (j > 0)
          prefR[i][j] += prefR[i][j - 1];
        if (i > 0)
          prefC[i][j] += prefC[i - 1][j];
        if (i > 0 && j > 0)
          prefLD[i][j] += prefLD[i - 1][j - 1];
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = m - 1; j >= 0; j--) {
        prefRD[i][j] = grid[i][j];
        if (i > 0 && j < m - 1)
          prefRD[i][j] += prefRD[i - 1][j + 1];
      }
    }
    int maxLen = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int bottom = i;
        int left = j;
        while (bottom < n && left < m) {
          if (isMagicSquare(grid, i, j, left, bottom, prefR, prefC, prefLD, prefRD))
            maxLen = Math.max(left - j + 1, maxLen);
          bottom++;
          left++;
        }
      }
    }
    return maxLen;
  }

  private boolean isMagicSquare(int[][] grid, int i, int j, int left, int bottom, long[][] prefR, long[][] prefC,
      long[][] prefLD, long[][] prefRD) {
    long reqSum = prefR[i][left] - prefR[i][j] + grid[i][j];
    // for each row
    for (int x = i; x <= bottom; x++) {
      long sum = prefR[x][left] - prefR[x][j] + grid[x][j];
      if (reqSum != sum)
        return false;
    }
    // for each col
    for (int y = j; y <= left; y++) {
      long sum = prefC[bottom][y] - prefC[i][y] + grid[i][y];
      if (reqSum != sum)
        return false;
    }
    // for diagonals;
    long leftDSum = prefLD[bottom][left] - prefLD[i][j] + grid[i][j];
    long rightDSum = prefRD[bottom][j] - prefRD[i][left] + grid[i][left];
    if (leftDSum != reqSum || rightDSum != reqSum)
      return false;
    return true;
  }
}