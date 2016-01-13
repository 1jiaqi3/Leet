/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.
**/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        if(nums.length==0){
            return result;
        }
        if(nums.length==1){
            result.add(nums[0]);
            return result;
        }
        int m1=nums[0];
        int number1=1;
        int m2=0;
        int number2=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==m1){
                number1++;
            }
            else if(nums[i]==m2){
                number2++;
            }
            else if(number1==0){
                m1=nums[i];
                number1=1;
            }
            else if(number2==0){
                m2=nums[i];
                number2=1;
            }
            else{
                number1--;
                number2--;
            }
        }
        number1=0;
        number2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==m1){
                number1++;
            }
            if(nums[i]==m2){
                number2++;
            }
        }
        if(number1>nums.length/3){
            result.add(m1);
        }
        if(number2>nums.length/3&&m1!=m2){
            result.add(m2);
        }
        return result;
    }
}
