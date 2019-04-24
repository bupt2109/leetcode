/**
 * Created by LYX on 2019/4/24.
 */
public class leetcode1009 {

    public int bitwiseComplement(int N) {
        int a = 1;
        int b = 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if((N&a)!=0){
                count = i;
            }
            a <<= 1;
        }
        a = 1;
        for (int i = 0; i <= count; i++) {
            b = b|a;
            a <<= 1;
        }
        return N ^ b;
    }

    public static void main(String[] args) {
        leetcode1009 test = new leetcode1009();

        System.out.println(test.bitwiseComplement(5));//2
        System.out.println(test.bitwiseComplement(7));//0
    }
}
