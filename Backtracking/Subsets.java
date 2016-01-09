/**
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
**/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allset=new ArrayList<>();
        Arrays.sort(nums);
        return getSets(nums.length,allset,nums);
    }
    public List<List<Integer>> getSets(int index,List<List<Integer>> allset,int[] nums){
        if(index==0){
            List<Integer> newset=new ArrayList<>();
            allset.add(newset);
        }
        else{
            allset=getSets(index-1,allset,nums);
            List<List<Integer>> moreSet=new ArrayList<>();
            for(List<Integer> eachSet:allset){
                List<Integer> newset=new ArrayList<Integer>();
                newset.addAll(eachSet);
                newset.add(nums[index-1]);
                moreSet.add(newset);
            }
            allset.addAll(moreSet);
        }
        return allset;
    }
}
