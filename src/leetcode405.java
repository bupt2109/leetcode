/**
 * Created by YX on 2016/10/15.
 */
public class leetcode405 {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        int a = num,digit;
        if(a==0)
            return "0";
        while(a!=0){
            digit = a & 15;
            if (digit == 10)
                sb.append('a');
            else if (digit == 11)
                sb.append('b');
            else if (digit == 12)
                sb.append('c');
            else if (digit == 13)
                sb.append('d');
            else if (digit == 14)
                sb.append('e');
            else if (digit == 15)
                sb.append('f');
            else
                sb.append(digit);
            a=a>>>4;
        }
        return sb.reverse().toString();
    }
}
