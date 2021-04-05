class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // move non-zero forward
                nums[j++] = nums[i];
            }
        }
        
        // append zeros
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0; 
        }
    }
}

// Reference
// https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
