//Suppose a sorted array is rotated at some pivot unknown to you beforehand.

//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

//Find the minimum element.

//You may assume no duplicate exists in the array.
public class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;
        int mid=len/2;
        int i=0;
        int j=len-1;
        if(len==1) return nums[0];
        while(nums[mid]!=nums[i]&&nums[mid]!=nums[j]){
            if(nums[mid]<nums[i]&&nums[mid]<nums[j]){
                j=mid;
                mid=(i+j)/2;
            }
            else if(nums[mid]>nums[i]&&nums[mid]>nums[j]){
                i=mid;
                mid=(i+j)/2;
            }
            else if (nums[mid]<nums[j]&&nums[mid]>nums[i]){
                return nums[i];
            }
        }
        return nums[i]<nums[j]?nums[i]:nums[j];
    }
}
