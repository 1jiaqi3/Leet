//Suppose a sorted array is rotated at some pivot unknown to you beforehand.

//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

//You are given a target value to search. If found in the array return its index, otherwise return -1.

//You may assume no duplicate exists in the array.
public class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int i=0;
        int j=len-1;
        int mid=(i+j)/2;
        while(i!=j){
            if(nums[mid]>nums[i]){
                if(target<=nums[mid]&&target>=nums[i]){
                    j=mid;
                }
                else{
                    i=mid;
                }
                mid=(i+j)/2;
            }
            else if(nums[mid]<nums[i]){
                if(target>=nums[mid]&&target<=nums[j]){
                    i=mid;
                }
                else{
                    j=mid;
                }
                mid=(i+j)/2;
            }
            else{
                if(nums[i]==target)
                    return i;
                else if(nums[j]==target)
                    return j;
                else return -1;
            }
        }
        if(target==nums[i]) return i;
        else return -1;
    }
}
