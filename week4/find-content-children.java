import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        // int numOfSatisfiedChildren = 0;
        // for (int i = 0; i < g.length; i++) {
        //     for (int j = 0; j < s.length; j++) {
        //         if (s[j] >= g[i]) {
        //             s[j] = -1;
        //             numOfSatisfiedChildren++;
        //             break;
        //         }
        //     }
        // }
        int numOfChildren = g.length;
        int numOfCookies = s.length;
        int numOfSatisfiedChildren = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                numOfSatisfiedChildren++;
            }
        }
        return numOfSatisfiedChildren;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(solution.findContentChildren(g, s));
    }
}

// Reference: https://leetcode-cn.com/problems/assign-cookies/solution/fen-fa-bing-gan-by-leetcode-solution-50se/