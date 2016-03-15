/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA >= lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                b = "0" + b;
            }
        } else {
            return addBinary(b, a);
        }
        System.out.println(a);
        System.out.println(b);
        String sum = "";
        String carry = "0";
        int p = a.length() - 1;
        while (p >= 0) {
            sum = (Character.getNumericValue(a.charAt(p)) ^ Character.getNumericValue(b.charAt(p))) + sum;
            carry = (Character.getNumericValue(a.charAt(p)) & Character.getNumericValue(b.charAt(p))) + carry;
            p--;
        }
        while (carry.length() >= 2 && carry.charAt(0) == '0') {
            carry = carry.substring(1);
        }
        if (carry.equals("0")) {
            return sum;
        } else {
            return addBinary(sum, carry);
        }
    }
}
