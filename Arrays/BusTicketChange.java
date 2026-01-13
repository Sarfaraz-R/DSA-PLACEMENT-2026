/*
You are given an array arr[] representing passengers in a queue. Each bus ticket costs 5 coins, and arr[i] denotes the note a passenger uses to pay (which can be 5, 10, or 20). You must serve the passengers in the given order and always provide the correct change so that each passenger effectively pays exactly 5 coins. Your task is to determine whether it is possible to serve all passengers in the queue without ever running out of change.

Examples:

Input: arr[] = [5, 5, 5, 10, 20]
Output: true
Explanation: From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change we return true.
Input: arr[] = [5, 5, 10, 10, 20]
Output: false
Explanation: From the first two customers in order, we collect two $5 bills. For the next two customers in order, we collect a $10 bill and give back a $5 bill. For the last customer, we can not give the change of $15 back because we only have two $10 bills. Since not every customer received the correct change, the answer is false.
Constraints:
1 ≤ arr.size() ≤ 10^5
arr[i] contains only [5, 10, 20]

*/
class Solution {
  public boolean canServe(int[] arr) {
    int fives = 0;
    int tens = 0;
    for (int c : arr) {
      int change = c - 5;
      if (c == 5)
        fives++;
      else if (c == 10)
        tens++;
      if (change == 15) {
        if (fives > 0 && tens > 0) {
          fives--;
          tens--;
        } else if (fives >= 3) {
          fives -= 3;
        } else
          return false;
      } else if (change == 5) {
        if (fives <= 0)
          return false;
        fives--;
      }
    }
    return true;
  }
}