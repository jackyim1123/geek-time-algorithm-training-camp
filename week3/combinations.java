class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>(); 
        if (k <= 0 || n < k ) {
            return ret;
        }
        Deque<Integer> path = new ArrayDeque<>(k);
        generate(1, n, k, path, ret);
        return ret;
    }

    public void generate(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> ret) {
        // terminator
        if (k == 0) {
            ret.add(new ArrayList<>(path));
            return;
        }
        if (begin > n - k + 1) {
            return;
        }

        // process current logic
        // not select
        generate(begin + 1, n, k, path, ret);

        // select
        path.addLast(begin);
        generate(begin + 1, n, k - 1, path, ret);

        // reverse
        path.removeLast();
    }
}

// Reference: https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
