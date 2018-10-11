/**
 * 832. Flipping an Image
 * Time: 2018-09-20 10:02
 *
 */
public class leetcode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int left, right, lv, rv;
        for(int i = 0; i< A.length; i++){
            int[] a = A[i];
            left = 0;
            right = a.length-1;
            while(left < right){
                lv = a[left];
                rv = a[right];
                a[left] = rv ^ 1;
                a[right] = lv ^ 1;
                left ++;
                right --;
            }
            if(left == right){
                a[left] = a[left] ^ 1;
            }
        }
        return A;
    }

    //一个有趣的思路： 对称的两个数如果不等的话，不用做任何变化！
    public int[][] flipAndInvertImage1(int[][] A) {
        return A;
    }

    public static void main(String[] args) {
//        int[][] A = {
//                {1,1,0,1},
//                {1,0,1,0},
//                {0,0,0,1}
//        };
        int[][] A = {
                {1},
                {1},
                {0}
        };
        leetcode832 leetcode832 = new leetcode832();
        int[][] aa = leetcode832.flipAndInvertImage(A);
        System.out.println("done");
    }
}
