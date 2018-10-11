/**
 * Created by YX on 2016/11/1.
 */
public class leetcode441 {

    //求解一元二次不等式法，O(1)复杂度，运行时间49ms（比我的方法还多时间？）
    public int arrangeCoins1(int n) {
        return (int)(-0.5+Math.sqrt(1+8*(long)n)/2);
    }
    //binary search。o(log(65535))复杂度,运行时间48ms
    //n最大值2^31-1,故x最大值为65535，边界条件预先处理，
    //全程没有用long，double，除法，时间可能比较快一点吧233
    public int arrangeCoins(int n) {
        int end = 65535,begin=0,mid=0;
        if(n==0)
            return begin;
        if(n>=2147450880)
            return end;
        while(begin<end){
            mid = (end+begin)>>1;
            if((mid&1)==1){//   odd
                if(mid*((mid+1)>>1) <= n){
                    if((mid+2)*((mid+1)>>1) > n){
                        break;
                    }
                    else{
                        begin = mid;
                    }
                }
                else{
                    end = mid;
                }
            }
            else{//   even
                if((mid>>1)*(mid+1) <= n){
                    if(((mid+2)>>1)*(mid+1) > n){
                        break;
                    }
                    else{
                        begin = mid;
                    }
                }
                else{
                    end = mid;
                }
            }
        }
        //System.out.println(begin+" "+mid+" "+end);
        return mid;
    }

    /*public static void main(String[] args) {
        leetcode441 test= new leetcode441();
        test.arrangeCoins(2147450879);
    }*/

}
