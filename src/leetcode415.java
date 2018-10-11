/**
 * Created by YX on 2016/10/14.
 */
/*Add Strings
Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
        Note:
        The length of both num1 and num2 is < 5100.
        Both num1 and num2 contains only digits 0-9.
        Both num1 and num2 does not contain any leading zero.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.*/

public class leetcode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        boolean flag=false;
        int i,j,ch;
        for(i=ch1.length-1,j=ch2.length-1; i>=0 || j>=0;i--,j--){
            ch = (i>=0?ch1[i]-'0':0)+(j>=0?ch2[j]-'0':0)+(flag?1:0);
            if(ch>9) {
                sb.append(ch - 10);
                flag=true;
            }
            else{
                sb.append(ch);
                flag=false;
            }
        }
        if(flag)
            sb.append(1);
        return sb.reverse().toString();
    }
}
