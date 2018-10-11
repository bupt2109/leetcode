/**
 * License Key Formatting
 * Time: 2018-09-19 15:48
 */
public class leetcode482 {
    public String licenseKeyFormatting(String S, int K) {
        char[] chs = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chs.length - 1, j = 0; i>=0 ; i--) {
            if(chs[i] != '-'){
                sb.append(chs[i]>='a'?(char)(chs[i]-32):chs[i]);
                j++;
                if(j%K==0){
                    sb.append('-');
                }
            }
        }
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='-'){
            sb = sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        //"--a-a-a-a-a--"
        //"---"
    }
}
