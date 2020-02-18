import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode0204
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap @Math
 * @Description
 * @Date 2019/11/7
 */
public class Leetcode0204 {

    //4年前的答案 Accepted	224 ms
    public int countPrimes1(int n) {
        if(n<=2)
            return 0;
        int res=1;//primes 2 exists
        int[] primes = new int[n/2+1];
        primes[0]=2;
        boolean flag=true;
        for(int i=3;i<n;i+=2){//3 5 7 9
            flag=true;
            for(int j=0;j<res && primes[j]*primes[j]<=i;j++){
                if(i%primes[j]==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                primes[res++]=i;
            }
        }
        return res;
    }

    /**
     * 厄拉多塞筛法
     * 空间复杂度n
     * 时间复杂度肯定不到n^2，有人说是O(N log log N)
     * https://blog.csdn.net/Gavin_Nicholas/article/details/88974079
     * Accepted	13 ms	38.9 MB
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] table = new boolean[n + 1];
        int count = 0;
        int cur = 2;
        int index;
        while(cur < n){
            if(!table[cur]){//是质数
                count ++;
                index = cur + cur;
                while(index < n){
                    table[index] = true;
                    index += cur;
                }
            }
            cur ++;
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode0204 leetcode0204 = new Leetcode0204();
        System.out.println(leetcode0204.countPrimes(50000));;
    }


}
