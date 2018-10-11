import java.util.*;

/**
 * Author:
 * Time: 2018-10-11 15:09
 * Copyright (C) 2018
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 Return a list of all uncommon words.
 You may return the list in any order.
 Example 1:
 Input: A = "this apple is sweet", B = "this apple is sour"
 Output: ["sweet","sour"]
 Example 2:
 Input: A = "apple apple", B = "banana"
 Output: ["banana"]
 Note:
 0 <= A.length <= 200
 0 <= B.length <= 200
 A and B both contain only spaces and lowercase letters.
 */
public class leetcode884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
//        Set<String> aset1 = new HashSet<>();
//        Set<String> aset2 = new HashSet<>();
//        Set<String> bset1 = new HashSet<>();
//        Set<String> bset2 = new HashSet<>();
//        for(String s: a){
//            if(!aset2.contains(s)){
//                if(aset1.contains(s)){
//                    aset1.remove(s);
//                    aset2.add(s);
//                }else{
//                    aset1.add(s);
//                }
//            }
//        }
//        for(String s: b){
//            if(!bset2.contains(s)){
//                if(bset1.contains(s)){
//                    bset1.remove(s);
//                    bset2.add(s);
//                }else{
//                    bset1.add(s);
//                }
//            }
//        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for(String s: a){
            if(map1.containsKey(s)){
                map1.put(s, map1.get(s)+1);
            }else{
                map1.put(s, 1);
            }
        }
        for(String s: b){
            if(map2.containsKey(s)){
                map2.put(s, map2.get(s)+1);
            }else{
                map2.put(s, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(entry.getValue()==1 && !map2.containsKey(entry.getKey())){
                res.add(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if(entry.getValue()==1 && !map1.containsKey(entry.getKey())){
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
