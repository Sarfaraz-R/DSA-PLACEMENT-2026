/*
Expression contains redundant bracket or not

Given a string of balanced expression s, check if it contains a redundant parenthesis or not. A set of parenthesis are redundant if the same sub-expression is surrounded by unnecessary or multiple brackets.
Note: Expression may contain + , - , *, and / operators. Given expression is valid and there are no white spaces present.

Examples:

Input: s = "((a+b))"
Output: true 
Explanation: ((a+b)) can reduced to (a+b).
Input: s = "(a+(b)/c)"
Output: true
Explanation: (a+(b)/c) can reduced to (a+b/c) because b is surrounded by () which is redundant.
Input: s = "(a+b+(c+d))"
Output: false
Explanation:(a+b+(c+d)) doesn't have any redundant or multiple brackets.


Constraints:
1 ≤ |s| ≤10^5
 */

class Solution {
  public static boolean checkRedundancy(String s) {
    Stack<Character> st = new Stack<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
        continue;
      if (ch == ')') {
        if (st.peek() == '(')
          return true;
        while (!st.isEmpty() && st.peek() != '(')
          st.pop();
        st.pop();
      } else {
        st.push(ch);
      }
    }
    return false;
  }
}
