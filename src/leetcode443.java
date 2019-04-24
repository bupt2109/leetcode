/**
 * Created by LYX on 2019/4/24.
 */
public class leetcode443 {
    public int compress(char[] chars) {
        int index = 0;
        int count = 1;
        char lastChar = chars[0];
        for (int i = 1; i <= chars.length; i++) {
            if(i == chars.length || chars[i] != lastChar){
                chars[index ++] = lastChar;
                if(count != 1){
                    if(count < 10) {
                        chars[index] = (char) (48 + count);
                        index ++;
                    }else{
                        char[] numbers = ("" + count).toCharArray();
                        for (int j = 0; j < numbers.length; j++) {
                            chars[index] = numbers[j];
                            index ++;
                        }
                    }
                }
                count = 1;
                if(i != chars.length) {
                    lastChar = chars[i];
                }
            }else{
                count ++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        leetcode443 test = new leetcode443();
        char[] test1 = {'a','a','a','a','a','a','a','a','a','a','a','a','b','c','c','c','c','c','a','a'};
        int res1 = test.compress(test1);
        System.out.println(res1);
        System.out.println(test1);
    }
}
