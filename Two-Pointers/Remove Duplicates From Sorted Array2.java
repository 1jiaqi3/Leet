//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?

//For example,
//Given sorted array nums = [1,1,1,2,2,3],

//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
//It doesn't matter what you leave beyond the new length.
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3) 
            return nums.length;
        int cur=nums[0];
        int i=1;
        int j=1;
        int count=0;
        while(j<nums.length){
            if(!(nums[j]==cur&&count>0)){
                if(nums[j]==cur)
                    count++;
                else count=0;
                cur=nums[j];
                swap(nums,i,j);
                i++;
            }
            j++;
        }
        return i;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
