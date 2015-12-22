//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

//Do not allocate extra space for another array, you must do this in place with constant memory.

//For example,
//Given input array nums = [1,1,2],

//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
//It doesn't matter what you leave beyond the new length.
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0||nums.length==1) 
            return nums.length;
        int cur=nums[0];
        int i=1;
        int j=1;
        while(j<nums.length){
            if(nums[j]!=cur){
                cur=nums[j];
                swap(nums,i,j);
                i++;
            }
            j++;
        }
        return i;
    }
    public void swap(int[] nums,int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
