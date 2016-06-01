/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>(1, 
            new Comparator<HashMap.Entry<Integer, Integer>>() {
                public int compare(HashMap.Entry<Integer, Integer> p, HashMap.Entry<Integer, Integer> q) {
                    return q.getValue() - p.getValue();
                };
            });
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        for (int i = 0; i < k; i++) {
            ret.add(pq.poll().getKey());
        }
        return ret;
    }
}
