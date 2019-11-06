import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode0001
 *
 * @author yu
 * @version v1.0
 * @Description
 * @Date 2019/11/6
 *
 * HashMap经典题
 * @Topic: @Array @HashMap
 * leetcode刷的第一题！第一次提交和第二次提交都是2015/2016年的事情了！！！泪目
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Leetcode0001 {

    //O(N^2) 第一次提交，
    public int[] twoSum1(int[] nums, int target) {
        int tmp,a=-1,b=-1;
        for(int i=0;i<nums.length;i++){
            tmp=target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==tmp){
                    a=i;
                    b=j;
                    break;//为什么不在这return？？
                }
            }
        }
        int[] res={a,b};
        return res;
    }

    //O(N) 第二次提交，第一次见识到hashmap威力
    public int[] twoSum2(int[] nums, int target) {
        int[] res={-1,-1};
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return res;
    }

    //191106第三次提交，相当于优化了第二次的代码
    //因为要记录下标，所以只能用Hashmap不能用set
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    //test
    public static void main(String[] args) {
        Leetcode0001 test = new Leetcode0001();
        System.out.println(Arrays.toString(test.twoSum(new int[]{2,7,11,15},9)));
    }
}
