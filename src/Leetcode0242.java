/**
 * Leetcode0242
 Given two strings s and t , write a function to determine if t is an anagram of s.
 Example 1:
 Input: s = "anagram", t = "nagaram"
 Output: true

 Example 2:
 Input: s = "rat", t = "car"
 Output: false

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap @Sort
 * @Description
 * @Date 2020/2/18
 */
public class Leetcode0242 {

    /**
     * 草，没注意到s t长度还可能不一样，mmp的 ERROR:https://leetcode.com/submissions/detail/304484499/
     * 200218 Accepted	3 ms	38.9 MB https://leetcode.com/submissions/detail/304484728/
     * 限定都是小写字母，用数组即可。
     * 若不是限定小写字母，比如unicode，就要用HashMap了
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int SIZE = 26;
        int[] array = new int[SIZE * 2];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'a'] ++;
            array[SIZE + t.charAt(i)-'a'] ++;
        }
        for (int i = 0; i < SIZE; i++) {
            if(array[i]!=array[SIZE + i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 4年前的答案，一样的方法
     */
    public boolean isAnagram4Year(String s, String t) {
        if(s==null || t==null){
            return false;
        }
        if(s.equals(t) && s.length()<=1){
            return true;
        }
        if(s.equals(t) || (s.length()!=t.length())){
            return false;
        }

        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        int i,len=s.length();
        System.out.print(len);
        for(i=0;i<26;i++){
            alpha1[i]=0;
            alpha2[i]=0;
        }
        for(i=0;i<len;i++){
            alpha1[s.charAt(i)-97]++;
            alpha2[t.charAt(i)-97]++;
        }
        for(i=0;i<26;i++){
            if(alpha1[i]!=alpha2[i])
                return false;
        }
        return true;
    }
}
