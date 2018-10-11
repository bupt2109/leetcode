/**
 * Created by YX on 2016/11/2.
 */

//每个灯开始为关0
//每个灯开关次数与这个灯序列所有的因子有关
//8号灯 1,2,4,8轮都会有开关
//这样既和因子数量有关，若为奇数，则开启，若为偶数，则关闭
//
// 重点：：：因子成对出现！！！！
//
// 于是只有平方数如25 有因子5不成对出现，所以25号灯亮
//转换为简单地最大开方数

public class leetcode319 {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }


}
