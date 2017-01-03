/*
242. Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
            else
                map1.put(s.charAt(i),1);
        }
        for(int i=0;i<t.length();i++){
            if(map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i),map2.get(t.charAt(i))+1);
            else
                map2.put(t.charAt(i),1);
        }
        Map<Character,Integer> loop = map1.size()>map2.size()?map1:map2;
        Map<Character,Integer> check = map1.size()>map2.size()?map2:map1;
        for(Map.Entry<Character,Integer> me:loop.entrySet()){
            if(check.containsKey(me.getKey())){
                if(!check.get(me.getKey()).equals(me.getValue()))
                    return false;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
