import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode0202
 *
 * @author yu
 * @version v1.0
 * @Description
 * @Date 2019/11/6
 *
 * @Topic: @HashMap @Math
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer,
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
Example:

 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 */
public class Leetcode0202 {
    //四年前
    public boolean isHappy1(int n) {
        if(n<=0)
            return false;
        int sum=0;
        int digit;
        int tmp=n;
        boolean flag=true;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        do{
            while(tmp!=0){
                digit = tmp%10;
                tmp /= 10;
                sum += digit*digit;
            }
            if(sum==1)
                return true;
            if(map.containsKey(sum)){
                flag=false;
            }
            else{
                map.put(sum, 1);
                tmp=sum;
                sum=0;
            }

        }while(flag);
        return false;
    }

    //有改进的空间
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int cur = n;
        int next;
        do{
            set.add(cur);
            next = 0;
            while(cur != 0){
                next += (cur%10) * (cur%10);
                cur = cur/10;
            }
            cur = next;
        }
        while(next!=1 && !set.contains(next));
        return next == 1;
    }
}
