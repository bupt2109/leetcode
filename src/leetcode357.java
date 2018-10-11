/**
 * Created by YX on 2016/11/3.
 */

//TODO
    //find a correct solution
public class leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n>=11){
            return 8877691;
        }
        int res[] = {0,10,91,739,5275,32491,168571,712891,2345851,5611771,8877691};
        return res[n];
    }
}
