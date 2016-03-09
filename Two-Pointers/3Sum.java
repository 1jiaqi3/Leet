//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.

//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},

//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else {
                    ArrayList<Integer> newTriple = new ArrayList<>();
                    newTriple.add(nums[i]);
                    newTriple.add(nums[j]);
                    newTriple.add(nums[k]);
                    if (!set.contains(newTriple)) {
                        set.add(newTriple);
                        ret.add(newTriple);
                    }
                    j++;
                    k--;
                }
            }
        }
        return ret;
    }
}
