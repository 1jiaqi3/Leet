//Given a pattern and a string str, find if str follows the same pattern.

//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

//Examples:
//pattern = "abba", str = "dog cat cat dog" should return true.
//pattern = "abba", str = "dog cat cat fish" should return false.
//pattern = "aaaa", str = "dog cat cat dog" should return false.
//pattern = "abba", str = "dog dog dog dog" should return false.
//Notes:
//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

import java.util.*;
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map=new HashMap<>();
        Scanner strScan=new Scanner(str);
        for(int i=0;i<pattern.length();i++){
            if(!strScan.hasNext()) return false;
            String word=strScan.next();
            if(map.get(pattern.charAt(i))!=null&&!map.get(pattern.charAt(i)).equals(word)){
                return false;
            }
            else if(map.get(pattern.charAt(i))==null&&map.containsValue(word)){
                return false;
            }
            else if(map.get(pattern.charAt(i))==null){
                map.put(pattern.charAt(i),word);
            }
        }
        if(strScan.hasNext()) return false;
        else return true;
    }
}
