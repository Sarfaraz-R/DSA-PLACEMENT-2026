/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 

Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
 

Constraints:

2 <= arr.length <= 10^5
-106 <= arr[i] <= 10^6
*/

class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    int minAbsdiff = Integer.MAX_VALUE;
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      minAbsdiff = Math.min(minAbsdiff, arr[i] - arr[i - 1]);
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      if (arr[i] - arr[i - 1] == minAbsdiff) {
        ans.add(new ArrayList<>());
        ans.get(ans.size() - 1).add(arr[i - 1]);
        ans.get(ans.size() - 1).add(arr[i]);
      }
    }
    return ans;
  }
}