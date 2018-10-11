import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author:
 * Time: 2017-02-07 08:57
 * Copyright (C) 2017
 */

/*500. Keyboard Row
Given a List of words, return the words that can be typed using letters of alphabet
on only one row's of American keyboard like the image below.
Example 1:
        Input: ["Hello", "Alaska", "Dad", "Peace"]
        Output: ["Alaska", "Dad"]
Note:
        You may use one character in the keyboard more than once.
        You may assume the input string will only contain letters of alphabet.*/

/*Input:
        []
Output:
        null
Expected:
        []*/
public class leetcode500 {
    public String[] findWords(String[] words) {
//        if(words == null || words.length<1)
//            return null;
        HashMap<Character,Integer> map = new HashMap<Character,Integer> ();
        String[] rows = {"qwertyuiopQWERTYUIOP","asdfghjklASDFGHJKL","zxcvbnmZXCVBNM"};
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<rows[i].length();j++) {
                char ch = rows[i].charAt(j);
                map.put(ch,i);
            }
        }
        ArrayList<String> wordlist = new ArrayList<String>();
        for(String str: words){
            int row = map.get(str.charAt(0));
            for(char ch: str.toCharArray()){
                if(map.get(ch)!=row){
                    row=-1;
                    break;
                }
            }
            if(row>=0){
                wordlist.add(str);
            }
        }
        String[] res = new String[wordlist.size()];
        for(int i=0;i<res.length;i++){
            res[i] = wordlist.get(i);
        }
        return res;
    }
}
