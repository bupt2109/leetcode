import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * Time: 2018-09-26 14:55
 *  TODO 感觉leetcode上有问题
 */
public class leetcode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        char[] chs = paragraph.toLowerCase().toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if(chs[i]<'a' || chs[i]>'z'){
                chs[i] = ' ';
            }
        }
        String[] words = String.valueOf(chs).split(" ");
        Set<String> bannedSet = new HashSet<>();
        Map<String,Integer> resultMap = new HashMap<>();
        for (String ban : banned){
            bannedSet.add(ban);
        }
        for(String word : words){
            if(!word.equals("") && !bannedSet.contains(word)){
                if(resultMap.containsKey(word)){
                    resultMap.put(word,resultMap.get(word)+1);
                }else{
                    resultMap.put(word,1);
                }
            }
        }
        String max = null;
        int maxNum = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            if(entry.getValue() > maxNum){
                maxNum = entry.getValue();
                max = entry.getKey();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        leetcode819 test = new leetcode819();
        String[] banned =  {"abc","abcd","jeff"};
        System.out.println(test.mostCommonWord("abc abc? abcd the jeff!",banned));
    }
}
