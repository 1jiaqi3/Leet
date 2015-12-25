//Given a sorted array and a target value, return the index if the target is found. 
//If not, return the index where it would be if it were inserted in order.

//You may assume no duplicates in the array.

//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        boolean lowToHigh=true;
        int high=nums.length-1;
        int mid=(low+high)/2;
        while(low<=high){
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target){
                lowToHigh=true;
                low=mid+1;
                mid=(low+high)/2;
            }
            else if(nums[mid]>target){
                lowToHigh=false;
                high=mid-1;
                mid=(low+high)/2;
            }
        }
        if(lowToHigh) return low;
        else return high<0?0:high+1;
    }
}
