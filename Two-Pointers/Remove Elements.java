//Given an array and a value, remove all instances of that value in place and return the new length.

//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int i=0;
        int j=nums.length-1;
        while(j>=0&&nums[j]==val) j--;
        while(i<=j){
            if(nums[i]==val){
                swap(nums,i,j);
                while(nums[j]==val)
                j--;
            }
            i++;
        }
        return i;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
