/*
Josephus problem
Difficulty: EasyAccuracy: 57.26%Submissions: 133K+Points: 2
You are playing a game with n people standing in a circle, numbered from 1 to n. Starting from person 1, every kth person is eliminated in a circular fashion. The process continues until only one person remains.
Given integers n and k, return the position (1-based index) of the person who will survive.

Examples :

Input: n = 5, k = 2
Output: 3
Explanation: Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed. 
Finally, the person at position 5 is killed. So the person at position 3 survives. 
Input: n = 7, k = 3
Output: 4
Explanation: The elimination order is 3 → 6 → 2 → 7 → 5 → 1, and the person at position 4 survives.
Constraints:
1 ≤ n, k ≤ 500

*/

class Solution {
  public int josephus(int n, int k) {

    boolean[] isEliminated = new boolean[n];
    int[] next = new int[n];
    for (int i = 0; i < n; i++) {
      next[i] = (i + 1) % n;
    }
    int elemCount = 0;
    int ne = 0;
    while (elemCount < n - 1) {
      int m = k;
      while (m > 0) {
        ne = findNext(isEliminated, next, ne);
        m--;
        if (m > 0)
          ne = next[ne];
      }
      // System.out.println(ne);
      isEliminated[ne] = true;
      elemCount++;
    }
    for (int i = 0; i < n; i++) {
      if (!isEliminated[i])
        return i + 1;
    }
    return -1;
  }

  private int findNext(boolean[] isEliminated, int[] next, int cur) {
    if (!isEliminated[cur])
      return cur;
    return next[cur] = findNext(isEliminated, next, next[cur]);
  }
}

