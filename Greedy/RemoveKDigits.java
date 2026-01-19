/*
Given a non-negative integer s represented as a string and an integer k, remove exactly k digits from the string so that the resulting number is the smallest possible, while maintaining the relative order of the remaining digits.

Note : The resulting number must not contain any leading zeros.
If the resulting number is an empty string after the removal, return "0".

Examples:

Input: s = "4325043", k = 3
Output: 2043
Explanation: Remove the three digits 4, 3, and 5 to form the new number "2043" which is smallest among all possible removal.
Input: s = "765028321", k = 5
Output: 221
Explanation: Remove the five digits 7, 6, 5, 8 and 3 to form the new number "0221". Since we are not supposed to keep leading 0s, we get "221".
Constraints:
1 ≤ k ≤ |s| ≤ 10^6
*/
class Solution {
    public String removeKdig(String s, int k) {
       StringBuilder sb=new StringBuilder();
       sb.append(s.charAt(0));
       int n=s.length();
       for(int i=1;i<n;i++){
           char ch=s.charAt(i);
           
           while(sb.length()>0&&ch<sb.charAt(sb.length()-1)&&k>0){
               sb.deleteCharAt(sb.length()-1);
               k--;
           }
           sb.append(ch);
       }
       while(k>0){
           sb.deleteCharAt(sb.length()-1);
           k--;
       }
       int start=0;
       while(start<sb.length()&&sb.charAt(start)=='0'){
           start++;
       }
       if(start==sb.length())return "0";
       return sb.substring(start,sb.length());
    }
}