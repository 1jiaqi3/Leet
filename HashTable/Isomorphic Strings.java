//Given two strings s and t, determine if they are isomorphic.

//Two strings are isomorphic if the characters in s can be replaced to get t.

//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

//For example,
//Given "egg", "add", return true.

//Given "foo", "bar", return false.

//Given "paper", "title", return true.

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        int len=Math.min(s.length(),t.length());
        for(int i=0;i<len;i++){
            if(map.get(s.charAt(i))!=null&&map.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }
            else if(map.get(s.charAt(i))==null&&map.containsValue(t.charAt(i))){
                return false;
            }
            if(map.get(s.charAt(i))==null){
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}
