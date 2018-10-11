/**
 * 504. Base 7
 * Time: 2018-09-20 10:55
 * Given an integer, return its base 7 string representation.
 Example 1:
 Input: 100
 Output: "202"
 Example 2:
 Input: -7
 Output: "-10"
 Note: The input will be in range of [-1e7, 1e7].
 */
public class leetcode504 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        int shang, yushu;
        if(num == 0){
            return "0";
        }
        int num1 = num;
        if(num < 0){
            num1 = - num;
        }
        while(num1 != 0){
            shang = num1 / 7;
            yushu = num1 % 7;
            num1 = shang;
            sb.append(yushu);
        }
        if(num < 0){
            sb.append('-');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(14^3);
        leetcode504 l504 = new leetcode504();
        System.out.println(l504.convertToBase7(0));
        System.out.println(l504.convertToBase7(100));
        System.out.println(l504.convertToBase7(-6));
        System.out.println(l504.convertToBase7(-100));
    }
}
