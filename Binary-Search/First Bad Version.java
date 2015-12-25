/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

//You are a product manager and currently leading a team to develop a new product. 
//Unfortunately, the latest version of your product fails the quality check. 
//Since each version is developed based on the previous version, all the versions after a bad version are also bad.

//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

//You are given an API bool isBadVersion(version) which will return whether version is bad. 
//Implement a function to find the first bad version. You should minimize the number of calls to the API.
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n==1) return n;
        long low=1;
        long high=n;
        //if we don't use long, even low and high are with int range, low+high would overflow
        int mid=(int)((low+high)/2);
        while((mid-1)>=1&&(mid+1)<=n){
            if(isBadVersion(mid)&&!isBadVersion(mid-1)){
                return mid;
            }
            else if(isBadVersion(mid)&&isBadVersion(mid-1)){
                high=mid-1;
                mid=(int)((low+high)/2);
            }
            else if(!isBadVersion(mid)){
                low=mid+1;
                mid=(int)((low+high)/2);
            }
        }
        if(mid==1){
            if(isBadVersion(1)) return 1;
            else return 2;
        }
        else return n;
    }
}
