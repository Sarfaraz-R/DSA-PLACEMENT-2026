/*

85. Maximal Rectangle

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= rows, cols <= 200
matrix[i][j] is '0' or '1'.

*/



class Solution {
  public int maximalRectangle(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int ans = 0;
    int[] height = new int[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '0') {
          height[j] = 0;
          continue;
        }
        height[j]++;
      }
      int[] nse = calNSE(height);
      int[] pse = calPSE(height);
      for (int j = 0; j < m; j++) {
        int width = nse[j] - pse[j] - 1;
        ans = Math.max(width * height[j], ans);
      }
    }
    return ans;
  }

  private int[] calNSE(int[] height) {
    int n = height.length;
    Stack<Integer> st = new Stack<>();
    int[] nse = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && height[st.peek()] >= height[i])
        st.pop();
      nse[i] = st.isEmpty() ? n : st.peek();
      st.push(i);
    }
    return nse;
  }

  private int[] calPSE(int[] height) {
    int n = height.length;
    Stack<Integer> st = new Stack<>();
    int[] pse = new int[n];
    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && height[st.peek()] >= height[i])
        st.pop();
      pse[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }
    return pse;
  }
}