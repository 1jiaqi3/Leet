//Given an array of non-negative integers, you are initially positioned at the first index of the array.

//Each element in the array represents your maximum jump length at that position.

//Your goal is to reach the last index in the minimum number of jumps.

//For example:
//Given array A = [2,3,1,1,4]

//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

//Note:
//You can assume that you can always reach the last index.
public class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int start=0;
        int origStart=start;
        int pointer=start+1;
        int end=start+nums[start];
        int count=1;
        while(end<nums.length-1){
            while(pointer<nums.length-1&&pointer<=origStart+nums[origStart]){
                if(pointer+nums[pointer]>end){
                    end=pointer+nums[pointer];
                    start=pointer;
                }
                pointer++;
            }
            origStart=start;
            count++;
        }
        return count;
    }
}
