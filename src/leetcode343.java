/**
 * Created by YX on 2016/11/3.
 */
public class leetcode343 {
    public int integerBreak(int n) {
        if(n<2 || n>58)
            return -1;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int res=1;
        switch(n%3){
            case 0:break;
            case 1:res*=4;n-=4;break;
            case 2:res*=2;n-=2;break;
        }
        while(n!=0){
            res*=3;
            n-=3;
        }
        return res;
    }
}
