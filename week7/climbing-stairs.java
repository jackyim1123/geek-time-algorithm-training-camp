class Solution {
    public int climbStairs(int n) {
        // 1. Recursion O(2^n), if n<=2 return n; else return f(n-1) + f(n-2)
        // 2. DP, rolling array
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}

// Reference: https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/