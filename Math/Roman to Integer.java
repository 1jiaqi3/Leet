/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ret = map.get(s.charAt(s.length() - 1));
        if (s.length() == 1) {
            return ret;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int prev = map.get(s.charAt(i));
            int cur = map.get(s.charAt(i + 1));
            if (prev < cur) {
                ret += 0 - prev;
            } else {
                ret += prev;
            }
        }
        return ret;
    }
}
