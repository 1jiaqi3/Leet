//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
//Find all unique quadruplets in the array which gives the sum of target.

//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//The solution set must not contain duplicate quadruplets.
//    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//    A solution set is:
//    (-1,  0, 0, 1)
//    (-2, -1, 1, 2)
//    (-2,  0, 0, 2)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int k=j+1;
                int m=nums.length-1;
                while (k<m){
                    int sum=nums[i]+nums[j]+nums[k]+nums[m];
                    if(sum>target) m--;
                    else if(sum<target) k++;
                    else{
                        ArrayList<Integer> newFour=new ArrayList<>();
                        newFour.add(nums[i]);
                        newFour.add(nums[j]);
                        newFour.add(nums[k]);
                        newFour.add(nums[m]);
                        if(!set.contains(newFour)){
                            set.add(newFour);
                            result.add(newFour);
                        }
                        k++;
                        m--;
                    }
                }
            }
        }
        return result;
    }
}
