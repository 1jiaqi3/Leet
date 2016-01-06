//Given a positive integer, return its corresponding column title as appear in an Excel sheet.

//For example:

//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
public class Solution {
    public String convertToTitle(int n) {
    //Too lazy to use StringBuilder,actually StringBuilder is better style
        String result="";
        while(n!=0){
            n--;
            int remainder=n%26;
            char letter=(char)(remainder+'A');
            n/=26;
            result=letter+result;
        }
        return result;
    }
}
