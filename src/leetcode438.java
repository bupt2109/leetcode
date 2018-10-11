import java.util.ArrayList;
import java.util.List;

/**
 * Created by YX on 2016/10/25.
 */
//14ms
public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(s==null || s.length()<p.length())
            return list;
        int len1 = s.length(),len2=p.length(),diff = len1-len2+1,i,j;
        char[] ch2 = new char[26];
        char[] ch1 = new char[26];
        char[] pp = p.toCharArray();
        char[] ss = s.toCharArray();
        for(i=0;i<len2;i++){
            ch2[pp[i]-'a']++;
            ch1[ss[i]-'a']++;
        }
        for(i=0;i<26;i++){
            if(ch1[i]!=ch2[i])
                break;
        }
        if(i==26)
            list.add(0);
        for(i=1;i<diff;i++){
            ch1[ss[i-1]-'a']--;
            ch1[ss[i+len2-1]-'a']++;
            for(j=0;j<26;j++){
                if(ch1[j]!=ch2[j])
                    break;
            }
            if(j==26)
                list.add(i);
        }
        return list;
    }
}
