/*
 * Number of Valid Parentheses
 * Difficulty: MediumAccuracy: 59.72%Submissions: 12K+Points: 4Average Time: 30m
 * You are given a number n, your task is to find the number of all the valid
 * parentheses expressions of that length using only "(" and ")" brackets.
 * 
 * An input string of parentheses is valid if :
 * 
 * Open brackets must be closed in correct order.
 * Every close bracket has a corresponding open bracket.
 * For example - "()()" or "(())" are valid while ")()(" or "))((" are invalid
 * parentheses expressions.
 * 
 * Examples:
 * 
 * Input: n = 2
 * Output: 1
 * Explanation: There is only one possibe valid expressions of length 2 i.e.,
 * "()".
 * Input: n = 4
 * Output: 2
 * Explanation: Possibe valid expressions of length 4 are "(())" and "()()".
 * Input: n = 6
 * Output: 5
 * Explanation: Possibe valid expressions of length 6 are "((()))", "(())()",
 * "()(())", "()()()" and "(()())".
 * Constraints:
 * 1 ≤ n ≤ 20
 * 
 * 
 */

class Solution {
    int findWays(int n) {
        return findCount(0,n,0);
    }
    private int findCount(int count, int n, int cur){
        if(cur==n){
            return count==0?1:0;
        }
        int ans=0;
        //open paranthesis
        ans+=findCount(count+1,n,cur+1);
        
        //closed Paranthesis
        if(count>0){
            ans+=findCount(count-1,n,cur+1);
        }
        return ans;
    }
}
