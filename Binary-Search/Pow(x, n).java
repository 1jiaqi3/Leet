//Implement pow(x, n).
public class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        else if(n==Integer.MIN_VALUE) return 1/x*myPow(x,Integer.MAX_VALUE);
        else if(n<0) return 1/myPow(x,-n);
        else if(n%2==0) return myPow(x*x,n/2);
        else return x*myPow(x,n-1);
    }
}
