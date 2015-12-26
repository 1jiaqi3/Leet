//Implement int sqrt(int x).

//Compute and return the square root of x.
public class Solution {
    public int mySqrt(int x) {
        long low=0;
        //for any integer x, Sqrt(x)<=x/2+1.
        long high=x/2+1;
        long mid=(low+high)/2;
        while(low<=high){
            if(mid*mid==x) return (int)mid;
            else if(mid*mid<x){
                low=mid+1;
                mid=(low+high)/2;
            }
            else{
                high=mid-1;
                mid=(low+high)/2;
            }
        }
        return (int)high;
    }
}
