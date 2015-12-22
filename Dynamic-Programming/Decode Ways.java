//A message containing letters from A-Z is being encoded to numbers using the following mapping:

//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.

//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

//The number of ways decoding "12" is 2.
public class Solution {
    public int numDecodings(String s) {
        //if the first digit is 0, no solution exists.
        if(s.length()==0||s.charAt(0)=='0')
            return 0;
        if(s.length()==1) return 1;
        int[] dp=new int[s.length()];
        dp[0]=1;
        if(s.charAt(1)=='0'){
            //if the second digit is 0, there is at most 1 way. 
            //given that, if the first 2 digits is 10 or 20, then there is 1 way, otherwise there is 0 way.
            if(s.charAt(0)=='1'||s.charAt(0)=='2')
                dp[1]=1;
            else dp[1]=0;
        }
        //if the second digit is not 0, there is 1 way or 2 ways, depends on whether the 2 digits is within 11 to 26.
        else dp[1]=Integer.parseInt(s.substring(0,2))<=26&&Integer.parseInt(s.substring(0,2))>=11? 2:1;
        //loop the string, the method is similar to "climbing stairs" 
        for(int i=2; i<s.length();i++){
            //if the previous solution is 0, then there is no way to decode.
            if(dp[i-1]==0)
                dp[i]=0;
            else if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')
                    dp[i]=dp[i-2];
                else dp[i]=0;
            }
            else{
                if(s.charAt(i-1)=='0')
                    dp[i]=dp[i-1];
                else if(Integer.parseInt(s.substring(i-1,i+1))<=26&&Integer.parseInt(s.substring(i-1,i+1))>=11)
                    dp[i]=dp[i-1]+dp[i-2];
                else dp[i]=dp[i-1];
            }
        }
        return dp[s.length()-1];
    }
}
