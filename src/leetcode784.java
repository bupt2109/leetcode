import java.util.ArrayList;
import java.util.List;

/**
 * Letter Case Permutation
 * Time: 2018-09-19 14:27
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 Note:

 S will be a string with length at most 12.
 S will consist only of letters or digits.
 */
public class leetcode784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if(S==null || S.length()==0){
            res.add(S);
            return res;
        }
        char[] chs = S.toCharArray();
        int[] indexes = new int[chs.length];
        char[] lower = new char[chs.length];
        char[] upper = new char[chs.length];
        int count = 0;
        for(int i = 0; i < chs.length; i++){
            char ch = chs[i];
            if(ch >= 'A'){
                lower[count] = upper[count] = ch;
                if(ch <= 'Z'){
                    lower[count] = (char)(ch + 32);
                }else{
                    upper[count] =(char)(ch - 32);
                }
                indexes[count++] = i;
            }
        }
        if(count==0){
            res.add(S);
            return res;
        }
        int max = (int)Math.pow(2,count);
        int num = 0;
        while(num < max){
            int i = 1, pos = count-1;
            while(i < max){
                if((i & num) == 0){//lower
                    chs[indexes[pos]] = lower[pos];
                }else{//upeer
                    chs[indexes[pos]] = upper[pos];
                }
                i = i << 1;
                pos --;
            }
            res.add(String.valueOf(chs));
            num ++;
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode784 test = new leetcode784();
        List<String> res = test.letterCasePermutation("1u2jm3hFE4");
        for (String str: res) {
            System.out.println(str);
        }
    }
}
