/**
 * Created by LYX on 2019/4/25.
 */
public class leetcode724 {
    /**
     * The length of nums will be in the range [0, 10000].
     * Each element nums[i] will be an integer in the range [-1000, 1000].
     * @param nums array
     * @return
     */
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = 0;
        int i = 1;
        while(i < nums.length){
            right += nums[i++];
        }
        if(right == 0){
            return 0;
        }
        for (i = 1; i <= nums.length-1; i++) {
            left += nums[i-1];
            right -= nums[i];
            if(left == right) {
                return i;
            }
        }
        return -1;
    }

    /**
     * (题意不清导致，还可以是0(这样左边是空的竟然也可以)真是没想到)
     * 右边是空的就不行QAQ
     * wrong answer:
     * Input     [-1,-1,-1,0,1,1]
     * Output     -1
     * Expected   0
     *
     * 第二次错因为[] 应该返回-1
     *
     * 第三次错因为最后一个元素满足时，被我跳过了
     *
     * @param args
     */
    public static void main(String[] args) {
        leetcode724 test = new leetcode724();
        int[] array = {-1,-1,0,1,1,0};
        System.out.println(test.pivotIndex(array));
    }
}
