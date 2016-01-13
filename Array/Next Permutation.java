/**
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
**/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==1){
            return;
        }
        int p1=nums.length-2;
        while(p1>=0&&nums[p1]>=nums[p1+1]){
            p1--;
        }
        if(p1==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        int p2=nums.length-1;
        while(p2>0&&nums[p2]<=nums[p1]){
            p2--;
        }
        swap(nums,p1,p2);
        reverse(nums,p1+1,nums.length-1);
    }
    public void swap(int[] nums, int p1, int p2){
        int tmp=nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=tmp;
    }
    public void reverse(int[] nums, int p1, int p2){
        while(p1<=p2){
            swap(nums,p1,p2);
            p1++;
            p2--;
        }
    }
}
