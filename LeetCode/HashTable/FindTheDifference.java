/*
389. Find the Difference
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
*/
public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
            else
                map1.put(s.charAt(i),1);
            if(map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i),map2.get(t.charAt(i))+1);
            else
                map2.put(t.charAt(i),1);
        }
        if(map2.containsKey(t.charAt(t.length()-1)))
            map2.put(t.charAt(t.length()-1),map2.get(t.charAt(t.length()-1))+1);
        else
            map2.put(t.charAt(t.length()-1),1);
        for(Map.Entry<Character,Integer> me:map2.entrySet()){
            if(map1.containsKey(me.getKey())){
                if(map1.get(me.getKey())!=me.getValue())
                    return me.getKey();
            }
            else
                return me.getKey();
        }
        return '0';
    }
}
