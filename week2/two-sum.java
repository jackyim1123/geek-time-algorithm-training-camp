class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 4 steps for solving problems:
        //   1. clarificartion 
        //   2. possible solutions
        //   3. coding 
        //   4. test cases
        // violence solution: 2 for loops, num[i] + nums[j] == target, output i, j, nums.length, 
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

// Reference: https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
