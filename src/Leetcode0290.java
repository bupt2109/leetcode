import java.util.HashMap;
import java.util.HashSet;

/**
 * Leetcode0290
 *
 * 290. Word Pattern https://leetcode.com/problems/word-pattern/
 Given a pattern and a string str, find if str follows the same pattern.
 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Example 1:
 Input: pattern = "abba", str = "dog cat cat dog"
 Output: true

 Example 2:
 Input:pattern = "abba", str = "dog cat cat fish"
 Output: false

 Example 3:
 Input: pattern = "aaaa", str = "dog cat cat dog"
 Output: false

 Example 4:
 Input: pattern = "abba", str = "dog dog dog dog"
 Output: false
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap
 * @Description
 * @Date 2020/2/18
 */
public class Leetcode0290 {

    /**
     * 200218 Accepted	0 ms	37.2 MB https://leetcode.com/submissions/detail/304497230/
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
     * Memory Usage: 37.2 MB, less than 5.41% of Java online submissions for Word Pattern.
     * 用了数组存字母-单词映射，set存单词是否重复
     */
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length!=pattern.length()){
            return false;
        }
        String[] letters = new String[26];
        HashSet<String> set = new HashSet<>(strs.length);
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            if(letters[index] ==null){
                if(!set.add(strs[i])){
                    return false;
                }
                letters[index] = strs[i];
            }else{
                if(!letters[index].equals(strs[i])){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 3年多前。 https://leetcode.com/submissions/detail/64279362/
     * 用了hashmap（字母-单词）又用set
     */
    public boolean wordPattern3Year(String pattern, String str) {
        HashMap<Character,String> strmap = new HashMap<Character,String>();
        HashSet<String> strset = new HashSet<String>();
        String[] strs = str.split(" ");
        if(pattern.length()!=strs.length)
            return false;
        char[] ch = pattern.toCharArray();
        for(int i=0;i<strs.length;i++){
            if(strmap.containsKey(ch[i])){
                if(!strmap.get(ch[i]).equals(strs[i])){
                    return false;
                }
            }
            else{//no in map
                if(!strset.contains(strs[i])){
                    strset.add(strs[i]);
                }
                else{
                    return false;
                }
                strmap.put(ch[i], strs[i]);
            }
        }
        return true;
    }
}
