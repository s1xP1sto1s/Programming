/*
205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++){
            Integer tmp1 = map1.put(s.charAt(i),i);
            Integer tmp2 = map2.put(t.charAt(i),i);
            if(tmp1==null || tmp2==null){
                if(tmp1!=tmp2)
                    return false;
            }
            else{
                if(!tmp1.equals(tmp2))
                    return false;
            }
        }
        return true;
    }
}
