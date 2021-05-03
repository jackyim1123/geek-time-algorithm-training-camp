class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        // Solution 1: binary search
        long left = 1, right = x;
        long mid = 1;
        while (left <= right) {
            // in case sum over the boundary
            // mid = (left + right) / 2;
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }
}