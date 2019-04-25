import java.util.Stack;

/**
 * Created by YX on 2016/11/2.
 */
/*example:
        s = "3[a]2[bc]", return "aaabcbc".
        s = "3[a2[c]]", return "accaccacc".
        s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
//a difficult question
public class leetcode394 {

    public String decodeString(String s) {
        if(s==null){
            return null;
        }
        if(s.length()==0)
            return "";
        StringBuilder res = new StringBuilder();

        Stack<String> stack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int number = 0;

        for(char ch: s.toCharArray()){
            if(ch == '['){
                numberStack.push(number);
                number = 0;
            }else if(ch == ']'){
                String pre = stack.pop();
                String abc = sb.toString();
                int num = numberStack.pop();
                StringBuilder combine = new StringBuilder();
                if(abc.equals("")){
                    abc = pre;
                    pre = stack.pop();
                }
                combine.append(pre);
                for (int i = 0; i < num; i++) {
                    combine.append(abc);
                }
                sb.delete( 0, sb.length());
                if(!stack.isEmpty()) {
                    sb.append(combine.toString());
                }else{
                    res.append(combine.toString());
                }
            }else if(ch >= '0' && ch <= '9'){
                if(number == 0){
                    String tmp = sb.toString();
                    stack.push(tmp);
                    sb.delete( 0, sb.length());
                }
                number = number * 10 + (ch - '0');
            }else{
                sb.append(ch);
            }
        }
        res.append(sb);
        return res.toString();
    }

    public static void main(String[] args) {
        leetcode394 test = new leetcode394();
        String res = test.decodeString("rpo3[a]btjdls2[b3[po]c]tfr12[o3[d]]i");
        System.out.println(res);
        System.out.println(res.equals("rpoaaabtjdlsbpopopocbpopopoctfrodddodddodddodddodddodddodddodddodddodddodddodddi"));
    }
}
