/*
2975. Maximum Square Area by Removing Fences From a Field

There is a large (m - 1) x (n - 1) rectangular field with corners at (1, 1) and (m, n) containing some horizontal and vertical fences given in arrays hFences and vFences respectively.

Horizontal fences are from the coordinates (hFences[i], 1) to (hFences[i], n) and vertical fences are from the coordinates (1, vFences[i]) to (m, vFences[i]).

Return the maximum area of a square field that can be formed by removing some fences (possibly none) or -1 if it is impossible to make a square field.

Since the answer may be large, return it modulo 109 + 7.

Note: The field is surrounded by two horizontal fences from the coordinates (1, 1) to (1, n) and (m, 1) to (m, n) and two vertical fences from the coordinates (1, 1) to (m, 1) and (1, n) to (m, n). These fences cannot be removed.

 

Example 1:



Input: m = 4, n = 3, hFences = [2,3], vFences = [2]
Output: 4
Explanation: Removing the horizontal fence at 2 and the vertical fence at 2 will give a square field of area 4.
Example 2:



Input: m = 6, n = 7, hFences = [2], vFences = [4]
Output: -1
Explanation: It can be proved that there is no way to create a square field by removing fences.
 

Constraints:

3 <= m, n <= 10^9
1 <= hFences.length, vFences.length <= 600
1 < hFences[i] < m
1 < vFences[i] < n
hFences and vFences are unique.
*/

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
      int mod=(int)1e9+7;
      ArrayList<Integer> v=new ArrayList<>();
      ArrayList<Integer> h=new ArrayList<>();
      v.add(1);
      for(int f:vFences){
        v.add(f);
      }
      v.add(n);
      h.add(1);
      for(int f:hFences){
        h.add(f);
      }
      h.add(m);
      Set<Integer> vdist=new HashSet<>();
      for(int i=0;i<v.size();i++){
        for(int j=i+1;j<v.size();j++){
            vdist.add(Math.abs(v.get(j)-v.get(i)));
        }
      }
      long max=-1;
      for(int i=0;i<h.size();i++){
        for(int j=i+1;j<h.size();j++){
          int dist=Math.abs(h.get(i)-h.get(j));
          if(vdist.contains(dist)){
            max=Math.max(dist,max);
          }
        }
      }
      if(max==-1)return -1;
      long MOD = 1_000_000_007;
      return (int) ((max * max) % MOD);
    }
}