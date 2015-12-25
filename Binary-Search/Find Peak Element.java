//A peak element is an element that is greater than its neighbors.

//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

//You may imagine that num[-1] = num[n] = -∞.

//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//Note:
//Your solution should be in logarithmic complexity.
public class Solution {
    public int findPeakElement(int[] nums) {
        int len=nums.length;
        if(len==1) return 0;
        int low=0;
        int high=len-1;
        int mid=(low+high)/2;
        while((mid-1)>=0&&(mid+1)<len){
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1])
                return mid;
            else if(nums[mid]<nums[mid-1]){
                high=mid-1;
                mid=(low+high)/2;
            }
            else if(nums[mid]<nums[mid+1]){
                low=mid+1;
                mid=(low+high)/2;
            }
        }
        if(mid==0){
            if(nums[mid]>nums[mid+1])
            return mid;
            else return mid+1;
        }
        else{
            if(nums[mid]>nums[mid-1])
            return mid;
            else return mid-1;
        }
    }
}
