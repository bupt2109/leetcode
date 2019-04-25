/**
 * Created by YX on 2016/11/8.
 *
 * 只有一个最大，其他N-1个都最小且值相等时，只需N-1步。
 111115  ->   4步
 111125  ->   5步
 一个变成2增加一步因为：经过一步变城222226（等价于111115）
 推证，最小的不用管，比最小的大的需要 x-min，累加起来即可。
 */
public class leetcode453 {
    public int minMoves(int[] nums) {
        int len = nums.length;
        int max = nums[0],min = nums[0];
        for(int i=1;i<len;i++){
            if(nums[i] > max){
                max = nums[i];
            }else if(nums[i] < min){
                min = nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != min){
                res += (nums[i] - min);
            }
        }
        return res;
    }

    /**
     * 改进，不需要算最大值，只需要最小值，相减就可以了
     * @param nums
     * @return
     */
    public int minMoves1(int[] nums) {
        int min = nums[0];
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res += (nums[i] - min);
        }
        return res;
    }


    /**
     * [1,1,2147483647]
     * -4
     * Expected     2147483646
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        leetcode453 test = new leetcode453();
        int [] a = {1,1,Integer.MAX_VALUE};
//        int [] a = {1,1,2,3,4,5,Integer.MAX_VALUE};
        System.out.println(test.minMoves(a));
    }
}
