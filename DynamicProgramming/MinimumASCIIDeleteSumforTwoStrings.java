/* 
712. Minimum ASCII Delete Sum for Two Strings


Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

 

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 

Constraints:

1 <= s1.length, s2.length <= 1000
s1 and s2 consist of lowercase English letters.
*/

class Solution {
  public int minimumDeleteSum(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] dp = new int[n][m];
    int[] pref1 = new int[n];
    int[] pref2 = new int[m];
    buildPrefix(pref1, pref2, s1, s2);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int c1 = (int) (s1.charAt(i));
        int c2 = (int) (s2.charAt(j));
        if (c1 == c2) {
          if (i > 0 && j > 0) {
            dp[i][j] = dp[i - 1][j - 1];
          } else if (i == 0 && j == 0) {
            dp[i][j] = 0;
          } else if (i == 0) {
            dp[i][j] = pref2[j - 1];
          } else { // j == 0
            dp[i][j] = pref1[i - 1];
          }
        } else {
          int deletei = c1 + (i - 1 < 0 ? pref2[j] : dp[i - 1][j]);
          int deletej = c2 + (j - 1 < 0 ? pref1[i] : dp[i][j - 1]);
          dp[i][j] = Math.min(deletei, deletej);
        }
      }
    }
    return dp[n - 1][m - 1];
  }

  private void buildPrefix(int[] pref1, int[] pref2, String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    pref1[0] = (int) s1.charAt(0);
    pref2[0] = (int) s2.charAt(0);
    for (int i = 1; i < n; i++) {
      int c = (int) s1.charAt(i);
      pref1[i] = pref1[i - 1] + c;
    }
    for (int i = 1; i < m; i++) {
      int c = (int) s2.charAt(i);
      pref2[i] = pref2[i - 1] + c;
    }

  }
}