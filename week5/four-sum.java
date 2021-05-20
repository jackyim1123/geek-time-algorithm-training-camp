
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 1. brute force: 4 fors O(n^4), if (a+b+c+d == target), new List{a,b,c,d}, if (!res.duplicate(list)) res.add(list);
        //    or use hash table to remove duplicate array
        // 2. double pointers O(n^3): 1. sort 2. for i, j, double pointer: j+1, n-1, 3. i+j+left+right >/</= target 4. lopping:
        //      - nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target
        //      - nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target
        //      - nums[i] + nums[j] + nums[j+1] + nums[j+2] > target
        //      - nums[i] + nums[j] + nums[n-2] + nums[n-1] < target
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // remove duplicate element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // cut useless branches
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length -1] < target) {
                continue;
            }            

            for (int j = i + 1; j < length - 2; j++) {
                // remove duplicate
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;                    
                }

                // cut useless branches
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length -2] + nums[length - 1] < target) {
                    continue;
                }
                
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if ( sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;                            
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++; 
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}

// Reference: https://leetcode-cn.com/problems/4sum/solution/si-shu-zhi-he-by-leetcode-solution/