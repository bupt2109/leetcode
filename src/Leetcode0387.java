import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Leetcode0387
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 Examples:
 s = "leetcode"
 return 0.
 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap @String
 * @Description 字符串中第一个只出现一次字符位置
 * @Date 2020/2/19
 */
public class Leetcode0387 {

    /**
     * 200219 Accepted	16 ms	42.1 MB https://leetcode.com/submissions/detail/304780861/
     * 用一个map记录字符出现第一次位置
     * 再用一个boolean数组记录是否重复
     *
     * 其他思路：先遍历统计字符出现次数，从头开始遍历看字符出现次数是否=1 （map.get(s.charAt(i))==1）
     */
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] array = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                array[map.get(ch)] = false;
            }else{
                map.put(ch, i);
                array[i] = true;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * Accepted	27 ms	41.7 MB 标准参考答案 https://leetcode.com/submissions/detail/304785425/
     */
    public int firstUniqChar1(String s) {
        if(s==null || s.length()==0){
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 完全一致的标准答案 Accepted	22 ms	42.2 MB
     * 时间和内存。。。还不如我的呢
     */
    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);//getOrDefault学到了吗？
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 4年前 两个map 52 ms https://leetcode.com/submissions/detail/72018646/
     */
    public int firstUniqChar4Year(String s) {
        if(s==null || s.length()==0)
            return -1;
        HashMap<Character, Integer> drop = new HashMap<Character, Integer>();
        HashMap<Character, Integer> res = new HashMap<Character, Integer>();
        char[] chs = s.toCharArray();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(drop.containsKey(ch)){
                continue;
            }
            if(res.containsKey(ch)){
                drop.put(ch, -1);
                res.remove(ch);
            }
            else{
                res.put(ch, i);
            }
        }
        if(res.isEmpty()){
            return -1;
        }
        else{
            int min = Integer.MAX_VALUE;
            for(Map.Entry<Character, Integer> entry: res.entrySet()){
                if(entry.getValue()<min)
                    min = entry.getValue();
            }
            return min;
        }
    }
}
