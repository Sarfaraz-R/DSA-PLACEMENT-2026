/*
Stream First Non-repeating

Given a string s consisting of only lowercase alphabets, for each index i in the string (0 ≤ i < n), find the first non-repeating character in the prefix s[0..i]. If no such character exists, use '#'.

Examples:

Input: s = "aabc"
Output: a#bb
Explanation: 
At i=0 ("a"): First non-repeating character is 'a'.
At i=1 ("aa"): No non-repeating character, so '#'.
At i=2 ("aab"): First non-repeating character is 'b'.
At i=3 ("aabc"): Non-repeating characters are 'b' and 'c'; 'b' appeared first, so 'b'. 
Input: s = "bb" 
Output: "b#" 
Explanation: 
At i=0 ("b"): First non-repeating character is 'b'.
At i=1 ("bb"): No non-repeating character, so '#'.
Constraints:
1 ≤ s.size() ≤ 10^5
 */

class Solution {
  public String firstNonRepeating(String s) {
    int n = s.length();
    int j = 0;
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      while (j <= i && map.get(s.charAt(j)) > 1)
        j++;
      char firstNonRepChar = j > i ? '#' : s.charAt(j);
      sb.append(firstNonRepChar);
    }
    return sb.toString();
  }
}