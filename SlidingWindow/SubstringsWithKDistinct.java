/*

You are given a string s consisting of lowercase characters and an integer k, You have to count all possible substrings that have exactly k distinct characters.

Examples :

Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]
Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]
Input: s = "aa", k = 1
Output: 3
Explanation: Possible substrings are ["a", "a", "aa"]
Constraints:
1 ≤ s.size() ≤ 10^6
1 ≤ k ≤ 26



*/
class Solution {
  public int countSubstr(String s, int k) {
    return atmost(s, k) - atmost(s, k - 1);
  }

  private int atmost(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int n = s.length();
    int ans = 0;
    int j = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      while (map.size() > k) {
        map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
        if (map.get(s.charAt(j)) == 0) {
          map.remove(s.charAt(j));
        }
        j++;
      }
      ans += (i - j + 1);
    }
    return ans;
  }
}