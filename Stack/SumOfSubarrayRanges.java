/*
Sum of subarray ranges
Difficulty: MediumAccuracy: 50.82%Submissions: 19K+Points: 4Average Time: 30m
Given an integer array arr[], the range of a subarray is defined as the difference between the largest and smallest elements within that subarray. Your task is to return the sum of the ranges of all possible subarrays in the array.

Note: It is guaranteed that the result will fit within a 32-bit integer.

Examples:

Input: arr[] = [1, 2, 3]
Output: 4
Explanation: The 6 subarray of arr are the following :
[1], range = largest - smallest = 1 - 1 = 0
[2], range = largest - smallest = 2 - 2 = 0
[3], range = largest - smallest = 3 - 3 = 0
[1, 2], range = largest - smallest = 2 - 1 = 1
[2, 3], range = largest - smallest = 3 - 2 = 1
[1, 2, 3], range = largest - smallest = 3 - 1 = 2
Sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4
Input: arr[] = [-32, 0, -2, 72]
Output: 318
Explanation: 
[-32], range = largest - smallest = -32 - (-32) = 0
[-32, 0], range = largest - smallest = 0 - (-32) = 32
[-32, 0, -2], range = largest - smallest = 0 - (-32) = 32
[-32, 0, -2, 72], range= largest - smallest = 72 - (-32) = 104
[0], range = largest - smallest = 0 - 0 = 0
[0, -2], range = largest - smallest = 0 - (-2) = 2
[0, -2, 72], range = largest - smallest = 72 - (-2) = 74
[-2], range = largest - smallest = -2 - (-2) = 0
[-2, 72], range = largest - smallest = 72 - (-2) = 74
[72], range = largest - smallest = 72 - 72 = 0
Sum of all ranges is 0 + 32 + 32 + 104 + 0 + 2 + 74 + 0 + 74 + 0 = 318
Constraints:
1 ≤ arr.size() ≤ 10^6
10-9 ≤ arr[i]  ≤ 10^9
 */

class Solution {
  public int subarrayRanges(int[] arr) {
    int n = arr.length;
    int[] nse = new int[n];
    int[] pse = new int[n];
    int[] nge = new int[n];
    int[] pge = new int[n];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && arr[st.peek()] > arr[i])
        st.pop();
      pse[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }
    st.clear();
    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && arr[st.peek()] < arr[i])
        st.pop();
      pge[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }
    st.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && arr[st.peek()] <= arr[i])
        st.pop();
      nge[i] = st.isEmpty() ? n : st.peek();
      st.push(i);
    }
    st.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && arr[st.peek()] >= arr[i])
        st.pop();
      nse[i] = st.isEmpty() ? n : st.peek();
      st.push(i);
    }
    st.clear();
    // System.out.println("pse: "+Arrays.toString(pse));
    // System.out.println("nse: "+Arrays.toString(nse));
    // System.out.println("pge: "+Arrays.toString(pge));
    // System.out.println("nge: "+Arrays.toString(nge));
    int range = 0;
    for (int i = 0; i < n; i++) {
      int max = (i - pge[i]) * (nge[i] - i) * arr[i];
      int min = (i - pse[i]) * (nse[i] - i) * arr[i];
      range += (max - min);
    }
    return range;
  }
}
