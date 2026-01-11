/*
Minimum Window Subsequence

You are given two strings, s1 and s2. Your task is to find the smallest substring in s1 such that s2 appears as a subsequence within that substring.

The characters of s2 must appear in the same sequence within the substring of s1.
If there are multiple valid substrings of the same minimum length, return the one that appears first in s1.
If no such substring exists, return an empty string.
Note: Both the strings contain only lowercase english letters.

Examples:

Input: s1 = "geeksforgeeks", s2 = "eksrg"
Output: "eksforg"
Explanation: "eksforg" satisfies all required conditions. s2 is its subsequence and it is smallest and leftmost among all possible valid substrings of s1.
Input: s1 = "abcdebdde", s2 = "bde" 
Output: "bcde"
Explanation:  "bcde" and "bdde" are two substring of s1 where s2 occurs as subsequence but "bcde" occur first so we return that.
Input: s1 = "ad", s2 = "b" 
Output: ""
Explanation: There is no substring exists.
Constraints:
1 ≤ s1.length ≤ 10^4
1 ≤ s2.length ≤ 50



*/

class Solution {
  public String minWindow(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int minLen = Integer.MAX_VALUE;

    int minStart = -1;
    int minEnd = -1;
    for (int i = 0; i < n; i++) {
      int start = i;
      int j = 0;
      while (start < n && j < m) {
        if (s1.charAt(start) == s2.charAt(j))
          j++;
        start++;
      }
      if (j == m) {
        int len = start - i;
        if (len < minLen) {
          minStart = i;
          minEnd = start;
          minLen = len;
        }
      }
    }
    if (minLen == Integer.MAX_VALUE)
      return "";
    return s1.substring(minStart, minEnd);
  }
}
