class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int size = nums.size();
        if (size == 0) {
            return;
        }

        // Solution 2
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                swap(nums[i], nums[j]);
                j++;
            }
        }

        // Solution 1
        // int cur = 0;
        // for (int i = 0; i < size; i++) {
        //     if (nums[i] != 0) {
        //         nums[cur] = nums[i];
        //         ++cur;
        //     }
        // }

        // while (cur < size) {
        //     nums[cur] = 0;
        //     ++cur;
        // }
    }
};