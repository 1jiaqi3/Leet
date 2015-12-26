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
        long low=1;
        long high=n;
        int mid=(int)((low+high)/2);
        while(low<=high){
            if(isBadVersion(mid)){
                high=mid-1;
                mid=(int)((low+high)/2);
            }
            else{
                low=mid+1;
                mid=(int)((low+high)/2);
            }
        }
        return (int)low;
    }
}
