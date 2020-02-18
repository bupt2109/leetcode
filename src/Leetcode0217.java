import java.util.HashMap;
import java.util.HashSet;

/**
 * Leetcode0217
 *
 * 217. Contains Duplicate
 Easy
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 Example 1:
 Input: [1,2,3,1]
 Output: true

 Example 2:
 Input: [1,2,3,4]
 Output: false

 Example 3:
 Input: [1,1,1,3,3,4,3,2,4,2]
 Output: true
 *
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap
 * @Description
 * @Date 2020/2/18
 */
public class Leetcode0217 {

    /**
     * 200218 Accepted	4 ms	46.7 MB	java
     * 简单的set集合
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length<2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }

    /**
     * 4 年前的方法，用了hashmap
     */
    public boolean containsDuplicate4Year(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            else{
                map.put(nums[i], 1);
            }
        }
        return false;
    }

    /**
     * Error: TLE
     * 4年前没有学到HashMap时，用双层循环超时
     */
    public boolean containsDuplicateError(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j])
                    return true;
            }
        }
        return false;
    }
}
