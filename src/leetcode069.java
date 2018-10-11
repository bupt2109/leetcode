/**
 * Created by YX on 2016/11/3.
 */
public class leetcode069 {
    public int mySqrt(int x) {
        double res = x;
        double last;
        do{
            last =  res;
            res = (res+x/res)/2;
            System.out.println(res);
        }while(Math.abs(res-last)>0.3);
        return (int)res;
    }

    /*public static void main(String[] args) {
        leetcode069 test = new leetcode069();
        test.mySqrt(2147395599);
    }*/
}
