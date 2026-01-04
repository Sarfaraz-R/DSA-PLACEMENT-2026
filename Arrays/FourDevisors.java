// 1390. Four Divisors

// Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.

// Example 1:

// Input: nums = [21,4,7]
// Output: 32
// Explanation: 
// 21 has 4 divisors: 1, 3, 7, 21
// 4 has 3 divisors: 1, 2, 4
// 7 has 2 divisors: 1, 7
// The answer is the sum of divisors of 21 only.
// Example 2:

// Input: nums = [21,21]
// Output: 64
// Example 3:

// Input: nums = [1,2,3,4,5]
// Output: 0

// Constraints:

// 1 <= nums.length <= 10^4
// 1 <= nums[i] <= 10^5

class Solution {
  public int sumFourDivisors(int[] nums) {
    int ans = 0;
    for (int num : nums) {
      int count = 0;
      int sum = 0;
      for (int i = 1; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
          sum += i;
          if (num / i != i) {
            sum += (num / i);
            count += 2;
          } else
            count += 1;
          ;
        }
      }
      if (count == 4)
        ans += sum;
    }
    return ans;
  }
}