/*
290. Word Pattern
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
/************************************************************************/
/*
思路没问题，但是要注意map1.put(pattern.charAt(i),i)!=map2.put(s[i],i)，put()返回的是Integer，!=比的是对象的引用，
Integer in1 = 127;
Integer in2 = 127;
System.out.println(in1==in2);
-128~127，以上返回都是true
*/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<String,Integer> map2 = new HashMap<String,Integer>();
        String[] s = str.split(" ");
        if(pattern.length()!=s.length)
            return false;
        for(int i=0;i<s.length;i++){
            if(map1.put(pattern.charAt(i),i)!=map2.put(s[i],i))//会出错，比的是引用
                return false;
        }
        return true;
    }
}
/***********************************************************************/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<String,Integer> map2 = new HashMap<String,Integer>();
        String[] s = str.split(" ");
        if(pattern.length()!=s.length)
            return false;
        for(int i=0;i<s.length;i++){
            Integer in1 = map1.put(pattern.charAt(i),i);
            Integer in2 = map2.put(s[i],i);
            if(in1==null || in2==null){
                if(in1!=in2)
                    return false;
            }
            else{
                if(!in1.equals(in2))
                    return false;
            }
        }
        return true;
    }
}
