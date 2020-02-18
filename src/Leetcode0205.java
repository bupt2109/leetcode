import java.util.HashMap;

/**
 * Leetcode0205
 *
 * Given two strings s and t, determine if they are isomorphic.
 Two strings are isomorphic if the characters in s can be replaced to get t.
 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.

 Example 1:
 Input: s = "egg", t = "add"
 Output: true
 Example 2:
 Input: s = "foo", t = "bar"
 Output: false
 Example 3:
 Input: s = "paper", t = "title"
 Output: true
 Note:
 You may assume both s and t have the same length.
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap
 * @Description
 * @Date 2020/2/18
 */
public class Leetcode0205 {

    /**
     * 4年前的答案，和现在差不多。算了两次
     */
    public boolean isIsomorphic4Year(String s, String t) {
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        char ch1,ch2;
        for(int i = 0;i < s.length();i++){
            ch1 = s.charAt(i);
            ch2 = t.charAt(i);
            if(map.containsKey(ch1)){
                if(map.get(ch1)!=ch2){
                    return false;
                }
            }
            else{
                map.put(ch1, ch2);
            }
        }
        map.clear();
        for(int i = 0;i < t.length();i++){
            ch1 = t.charAt(i);
            ch2 = s.charAt(i);
            if(map.containsKey(ch1)){
                if(map.get(ch1)!=ch2){
                    return false;
                }
            }
            else{
                map.put(ch1, ch2);
            }
        }
        return true;
    }

    /**
     * Wrong Answer
     * Input     "ab"     "aa"
     * Output     true
     * Expected     false
     * 题意理解不够，没注意到相互关系
     */
    public boolean isIsomorphicError(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            Character value = map.get(a);
            if(value == null){
                map.put(a, b);
            }else{
                if(value != b){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 2020-02-18提交
     * Accepted	8 ms	38.9 MB	java
     * 两个HashMap分别存a->b, b->a对应关系
     */
    public boolean isIsomorphicSuccess200218(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();    //a->b
        HashMap<Character, Character> map2 = new HashMap<>();    //b->a
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            Character value1 = map1.get(a);
            if(value1 == null){
                map1.put(a, b);
            }else{
                if(value1 != b){
                    return false;
                }
            }
            Character value2 = map2.get(b);
            if(value2 == null){
                map2.put(b, a);
            }else{
                if(value2 != a){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 新思路：需要的是存对应关系，char有长度极限（类似桶排），
     * 所以可以用128*2长度char数组存对应关系
     * Accepted	3 ms	38.5 MB  https://leetcode.com/submissions/detail/304494354/
     * 好像有bug，如果传的char是0怎么办会冲突？
     */
    public boolean isIsomorphic(String s, String t) {
        int[] array = new int[128*2];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(array[(int)a] == array[(int)b + 128] && array[(int)a] == 0){
                array[(int)a]=b;
                array[(int)b + 128]=a;
            }else if(array[(int)a]!=b || array[(int)b + 128]!=a){
                return false;
            }
        }
        return true;
    }
}
