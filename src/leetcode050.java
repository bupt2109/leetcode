/**
 * Created by YX on 2016/11/7.
 */


//基础问题：x^n 普通方法迭代O（n）
//数学方法O（logn）二分法，位法
//提高问题：大数乘法
//矩阵乘法-->斐波那契数列 f(n)=af(n-1)+bf(n-2)二阶递推式

public class leetcode050 {
    //迭代，O（n），
    /*Last executed input: 0.00001
        2147483647*/
    public double myPow1(double x, int n) {
        double res = 1;
        if(n>=0){
            for(int i=0;i<n;i++){
                res*=x;
            }
        }
        else{
            for(int i=0;i<0-n;i++){
                res*=x;
            }
            res=1/res;
        }
        return res;
    }

    public double myPow(double x, int n) {
        if(n<0){
            if(n==Integer.MIN_VALUE){
                return 1.0/(myPow(x,Integer.MAX_VALUE)*x);
            }
            return 1.0/myPow(x,-n);
        }
        double res = 1;
        for(;n>0;n>>=1){
            if((n&1)>0)
                res*=x;
            x*=x;
        }
        return res;
    }

    //代码思路一样，为什么更快呢？
    public double myPow2(double x, int n) {
        if(n == 0) { return 1.0; }
        if(x == 0) { return 0.0; }
        if(n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return (n > 0 ? x : 1.0 / x ) * myPow(x * x, n / 2) ;
        }
    }
}
