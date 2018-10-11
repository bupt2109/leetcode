import java.util.HashMap;

/**
 * Created by YX on 2016/10/14.
 */
public class leetcode409 {
    public int longestPalindrome(String s) {
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
