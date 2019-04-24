/**
 * Created by LYX on 2019/4/24.
 */
public class leetcode507 {
    public boolean checkPerfectNumber(int num) {
        if(num <= 5){
            return false;
        }
        int total = num - 1;
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num%i == 0){
                total -= i;
                total -= num/i;
                if(total < 0){
                    return false;
                }
            }
        }
        return total==0;
    }

    public static void main(String[] args) {
        leetcode507 test = new leetcode507();
        test.checkPerfectNumber(28);
    }
}
