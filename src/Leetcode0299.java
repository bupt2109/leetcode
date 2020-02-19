/**
 * Leetcode0299
 *
 * https://leetcode.com/problems/bulls-and-cows/
 * 299. Bulls and Cows
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in
 * both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 Please note that both secret number and friend's guess may contain duplicate digits.

 Example 1:
 Input: secret = "1807", guess = "7810"
 Output: "1A3B"
 Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

 Example 2:
 Input: secret = "1123", guess = "0111"
 Output: "1A1B"
 Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

 Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap
 * @Description 猜字符串，回答猜对几个和几个数字对了位置不对
 * @Date 2020/2/19
 */
public class Leetcode0299 {

    /**
     * 200219 Accepted	4 ms	38.2 MB https://leetcode.com/submissions/detail/304665897/
     *  数组桶存数值遍历计数。
     *  Error：没理解清楚题意关于cow的定义，结果，
     */
    public String getHint(String secret, String guess) {
        int[] cows = new int[10*2];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s == g){
                bull ++;
            }else{
                cows[s] ++;
                cows[g + 10] ++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if(cows[i] > 0 && cows[i + 10] > 0){
                cow += cows[i]>cows[i + 10]?cows[i + 10]:cows[i];
            }
        }
        return bull + "A" + cow + "B";
    }

    /**
     * 四年前答案，和现在方法一致。 https://leetcode.com/submissions/detail/66327326/
     */
    public String getHint4Year(String secret, String guess) {
        int a=0,b=0;
        int[] aa = new int[10];
        int[] bb = new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                a++;
            }
            else{
                aa[secret.charAt(i)-'0'] ++;
                bb[guess.charAt(i)-'0'] ++;
            }
        }
        for(int i=0;i<10;i++){
            if((bb[i]!=0)&&(aa[i]!=0)){
                if(bb[i]<=aa[i])
                    b+=bb[i];
                else
                    b+=aa[i];
            }
        }
        return a+"A"+b+"B";
    }

    /**
     * https://leetcode.com/problems/bulls-and-cows/discuss/74621/One-pass-Java-solution
     * 高赞答案，只用了一个10长度数组解决cows数量，因为是算差值，所以可以用一个数组。
     * 猜中了就-1，没猜中先+1放着
     int[] numbers = new int[10];
     else {
        if (numbers[s] < 0) cows++;
        if (numbers[g] > 0) cows++;
        numbers[s] ++;
        numbers[g] --;
     }
     */

}
