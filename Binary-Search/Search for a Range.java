//Given a sorted array of integers, find the starting and ending position of a given target value.

//Your algorithm's runtime complexity must be in the order of O(log n).

//If the target is not found in the array, return [-1, -1].

//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid=(low+high)/2;
        int start=searchStart(nums,target,low,high,mid);
        int end=searchEnd(nums,target,low,high,mid);
        return new int[] {start,end};
    }
    public int searchStart(int[] nums,int target,int low,int high,int mid){
        while(low<=high){
            if(nums[mid]<target){
                low=mid+1;
                mid=(low+high)/2;
            }
            else{
                high=mid-1;
                mid=(low+high)/2;
            }
        }
        if(low<nums.length&&nums[low]==target) return low;
        return -1;
    }
    public int searchEnd(int[] nums,int target,int low,int high,int mid){
        while(low<=high){
            if(nums[mid]<=target){
                low=mid+1;
                mid=(low+high)/2;
            }
            else{
                high=mid-1;
                mid=(low+high)/2;
            }
        }
        if(high>=0&&nums[high]==target) return high;
        return -1;
    }
}
