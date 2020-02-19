import java.util.HashMap;

/**
 * Leetcode0409
 * https://leetcode.com/problems/longest-palindrome/
 * 409. Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 This is case sensitive, for example "Aa" is not considered a palindrome here.
 Note:
 Assume the length of given string will not exceed 1,010.

 Example:
 Input:
 "abccccdd"
 Output:
 7
 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 *
 * @author yu
 * @version v1.1
 * @Topic: @HashMap
 * @Description 给定单词可以组成最长回文词的长度
 * @Date 2016/10/14.
 */
public class Leetcode0409 {

    /**
     * 看是否成对出现，成对出现即可参与回文，还有判断有没有奇数个数的，有的话奇数的放中间，回文长度可再加一
     * 200219 Accepted	2 ms	37.4 MB https://leetcode.com/submissions/detail/304798506/
     * 每次判断计算，不如最后数组里判断计算，因为：数组大小<<字符串大小！！！
     */
    public int longestPalindrome(String s) {
        boolean[] array = new boolean[52];
        int count = 0;//有几个偶数
        int odd = 0;//奇数个数
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if(ch<0){
                ch += (32+26);
            }
            if(array[ch]){
                count ++;
                array[ch] = false;
                odd --;
            }else{
                array[ch] = true;
                odd ++;
            }
        }
        return count*2 + (odd>0?1:0);
    }


    /**
     * 4年前的答案
     * Accepted	11 ms	N/A https://leetcode.com/submissions/detail/78433946/
     * 重新提交一次：Accepted	1 ms	37.5 MB  https://leetcode.com/submissions/detail/304798892/
     *
     */
    public int longestPalindrome4Year(String s) {
        int res=0;
        int count=0;
        int[] ch = new int[52];
        for(char a: s.toCharArray()){
            if(a>='a' && a<='z'){
                ch[a-'a']++;
            }
            else{
                ch[a-'A'+26]++;
            }
        }
        //这个算法不错啊！！就不用了每个字符都去判断处理了
        for(int i=0;i<52;i++){
            res+=ch[i];
            if(ch[i]%2==1){
                count++;
            }
        }
        if(count>1)
            res=res-count+1;
        return res;
    }
}
