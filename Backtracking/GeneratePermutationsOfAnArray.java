/*
Generate Permutations of an array

Given an array arr[] of unique elements. Generate all possible permutations of the elements in the array.
Note: You can return the permutations in any order, the driver code will print them in sorted order.

Examples:

Input: arr[] = [1, 2, 3]
Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
Explanation: There are 6 possible permutations (3! = 6) of the array.
Input: arr[] = [1, 3]
Output: [[1, 3], [3, 1]]
Explanation: There are 2 possible permutations (2! = 2) of the array.
Constraints:
1 ≤ arr.size() ≤ 9
*/

class Solution {
  public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
    int n = arr.length;
    boolean[] vis = new boolean[n];
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    helper(ans, new ArrayList<>(), arr, vis, 0);
    return ans;
  }

  private static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int[] arr, boolean[] vis,
      int takenElems) {
    if (takenElems == arr.length) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (!vis[i]) {
        vis[i] = true;
        temp.add(arr[i]);
        helper(ans, temp, arr, vis, takenElems + 1);
        temp.remove(temp.size() - 1);
        vis[i] = false;
      }
    }
  }

}