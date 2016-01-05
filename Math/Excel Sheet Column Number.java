//Given a column title as appear in an Excel sheet, return its corresponding column number.

//For example:

//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
public class Solution {
    public int titleToNumber(String s) {
        StringBuilder str=new StringBuilder(s);
        int sum=0;
        int pow=1;
        char letter=str.charAt(str.length()-1);
        int num=(int)(letter-'A'+1);
        sum+=num;
        str=str.deleteCharAt(str.length()-1);
        while(str.length()>0){
            letter=str.charAt(str.length()-1);
            num=(int)(letter-'A'+1);
            sum+=26*pow*num;
            pow*=26;
            str=str.deleteCharAt(str.length()-1);
        }
        return sum;
    }
}
