/**
 * Created by YX on 2016/11/2.
 */
/*example:
        s = "3[a]2[bc]", return "aaabcbc".
        s = "3[a2[c]]", return "accaccacc".
        s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
    //TODO
    //a difficult question
public class leetcode394 {
    public String decodeString(String s) {
        if(s==null){
            return null;
        }
        if(s.length()==0)
            return "";
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        char[] code= new char[chs.length-3];
        char ch;
        int k=0,m=0;
        boolean flag = true;
        for(int i=0;i<chs.length;i++){
            ch=chs[i];
            if(ch=='['){
                k/=10;
                flag=false;
                continue;
            }
            if(ch==']'){
                for(int ii=0;ii<k;ii++){
                    for(int jj=0;jj<m;jj++){
                        sb.append(code[jj]);
                    }
                }
                k=0;
                m=0;
                flag=true;
                continue;
            }
            if(flag){//k
                k+=(ch-'0');
                k*=10;
            }
            else{//code
                code[m++]=ch;
            }
        }
        return sb.toString();
    }

    /*public static void main(String[] args) {
        leetcode394 test = new leetcode394();
        System.out.println(test.decodeString(null));
    }*/
}
