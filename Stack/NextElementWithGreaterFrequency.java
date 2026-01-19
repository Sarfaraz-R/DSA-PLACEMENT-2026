// Next element with greater frequency

// Given an array arr[] of integers, for each element, find the first element to its right that has a higher frequency than the current element.
// If no such element exists, return -1 for that position.

// Examples:

// Input: arr[] = [2, 1, 1, 3, 2, 1]
// Output: [1, -1, -1, 2, 1, -1]
// Explanation: Frequencies: 1 → 3 times, 2 → 2 times, 3 → 1 time.
// For arr[0] = 2, the next element 1 has a higher frequency → 1.
// For arr[1] and arr[2], no element to the right has a higher frequency → -1.
// For arr[3] = 3, the next element 2 has a higher frequency → 2.
// For arr[4] = 2, the next element 1 has a higher frequency → 1.
// For arr[5] = 1, no elements to the right → -1.
// Input: arr[] = [5, 1, 5, 6, 6]
// Output: [-1, 5, -1, -1, -1]
// Explanation: Frequencies: 1 → 1 time, 5 → 2 times, 6 → 2 times.
// For arr[0] and arr[2], no element to the right has a higher frequency → -1.
// For arr[1] = 1, the next element 5 has a higher frequency → 5.
// For arr[3] and arr[4], no element to the right has a higher frequency → -1.
// Constraints:
// 1 ≤ arr.size() ≤ 10^5
// 1 ≤ arr[i] ≤ 10^5

class Solution {
  public ArrayList<Integer> nextFreqGreater(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = arr.length;
    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && map.get(st.peek()) <= map.get(arr[i]))
        st.pop();
      int nextG = st.isEmpty() ? -1 : st.peek();
      ans.add(nextG);
      st.push(arr[i]);
    }
    Collections.reverse(ans);
    return ans;
  }
}