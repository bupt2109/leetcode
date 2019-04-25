import java.util.HashSet;
import java.util.Set;

/**
 * Created by LYX on 2019/4/25.
 */
public class leetcode859 {
    public boolean buddyStrings(String A, String B) {
        if(A==null || B==null || A.length()!=B.length() || A.length()<2){
            return false;
        }
        int diff = 0;
        char a1=',',b1=',',a2=',',b2=',';
        char ch1,ch2;
        Set<Character> set = new HashSet<>();
        boolean morethan2 = false;
        for (int i = 0; i < A.length(); i++) {
            ch1 = A.charAt(i);
            ch2 = B.charAt(i);
            if(set.contains(ch1)){
                morethan2 = true;
            }else{
                set.add(ch1);
            }
            if(ch1 != ch2){
                if(diff == 2){
                    return false;
                }
                if(diff == 0){
                    a1 = ch1;
                    b1 = ch2;
                }else{
                    a2 = ch1;
                    b2 = ch2;
                }
                diff ++;
            }
        }
        if(diff == 1){
            return false;
        }else if(diff == 2){
            return (a1==b2 && a2==b1);
        }else{
            return morethan2;
        }
    }
}
