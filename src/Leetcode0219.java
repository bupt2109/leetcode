import java.util.HashMap;

/**
 * Leetcode0219
 *
 * 219. Contains Duplicate II
 Given an array of integers and an integer k,
 find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and
 the absolute difference between i and j is at most k.
 Example 1:
 Input: nums = [1,2,3,1], k = 3
 Output: true

 Example 2:
 Input: nums = [1,0,1,1], k = 1
 Output: true

 Example 3:
 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap
 * @Description
 * @Date 2020/2/18
 */
public class Leetcode0219 {

    /**
     * 200218 Accepted	6 ms	44.9 MB	java
     * 用了hashmap记录数字和下标（计算距离）
     * 便利查看并更新距离
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k<1 || nums==null || nums.length<2){
            return false;
        }
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer value = indexMap.get(num);
            if(value == null){
                indexMap.put(num, i);
            }else{
                if(i - value <= k){
                    return true;
                }else{
                    indexMap.put(num, i);
                }
            }
        }
        return false;
    }

    /**
     * 4年前的答案
     * 和现在几乎一模一样
     */
    public boolean containsNearbyDuplicate4Year(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if((i-map.get(nums[i]))<=k){
                    System.out.println(nums[i]);
                    return true;
                }
                else{
                    map.put(nums[i], i);
                }
            }
            else{
                map.put(nums[i], i);
            }
        }
        return false;
    }

}
