/**
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
**/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> allset=new ArrayList<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> set=new HashSet<>(); 
        return getSets(nums.length,allset,nums,set);
    }
    public List<List<Integer>> getSets(int index,List<List<Integer>> allset,int[] nums,HashSet<List<Integer>> set){
        if(index==0){
            List<Integer> newset=new ArrayList<>();
            allset.add(newset);
        }
        else{
            allset=getSets(index-1,allset,nums,set);
            List<List<Integer>> moreSet=new ArrayList<>();
            for(List<Integer> eachSet:allset){
                List<Integer> newset=new ArrayList<Integer>();
                newset.addAll(eachSet);
                newset.add(nums[index-1]);
                moreSet.add(newset);
            }
            for(List<Integer> eachSet:moreSet){
                if(!set.contains(eachSet)){
                    allset.add(eachSet);                    
                }
                set.add(eachSet);
            }
        }
        return allset;
    }
}
