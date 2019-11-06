/**
 * Leetcode0136
 *
 * @author yu
 * @version v1.0
 * @Description
 * @Date 2019/11/6
 *
 * @Topic: @HashMap @Bit
 * 位运算经典题
 *  191106按：这道题也是4年前提交的了。
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class Leetcode0136 {
    //第一次提交
    public int singleNumber1(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }

    //O(N) 1 异或位运算经典题。和四年前提交的没一点区别哈哈哈哈
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
