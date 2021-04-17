import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // statistics occurrence frequency using hash table
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
           
        // construct a small heap(asc sort), using PriorityQueue
        // int[0] = num, int[1] = count
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        // add top k frequent to queue
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            // if queue.size < k, add new int[]{num, count}
            // else compare heap head with count, if head < count, pop head, push count
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        // output result, reverse due to small heap
        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ret[i] = queue.poll()[0];
        }        
        return ret;
    }
}

// References:
// https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
