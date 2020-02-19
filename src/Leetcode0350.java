import java.util.Arrays;
import java.util.HashMap;

/**
 * Leetcode0350
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.

 Example 1:
 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2,2]

 Example 2:
 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [4,9]

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 3一种解法：https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82243/Solution-to-3rd-follow-up-question
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap @Two Pointers @Binary Search @Sort
 * @Description 找两个数组交集，结果集元素有几个重复就几个
 * @Date 2020/2/19
 */
public class Leetcode0350 {

    /**
     * Accepted	3 ms	39.3 MB https://leetcode.com/submissions/detail/304767897/
     * 一个hashmap，相比于0349，多了一个计数逐渐减一的过程
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
        for(int num: nums1){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        int count = 0;
        for(int num: nums2){
            if(map.containsKey(num)){
                int value = map.get(num);
                if(value>0){
                    res[count ++] = num;
                    map.put(num, value-1);
                }
            }
        }
        res = Arrays.copyOf(res, count);
        return res;
    }

    /**
     * 四年前，简单的两个hashmap https://leetcode.com/submissions/detail/63246981/
     */
    public int[] intersect4Year(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        for(int num:nums1){
            if(map1.containsKey(num)){
                map1.put(num, map1.get(num)+1);
            }
            else{
                map1.put(num, 1);
            }
        }
        for(int num:nums2){
            if(map2.containsKey(num)){
                map2.put(num, map2.get(num)+1);
            }
            else{
                map2.put(num, 1);
            }
        }
        int a,b,len=0;
        for (java.util.Map.Entry<Integer,Integer> entry : map2.entrySet()) {
            a=entry.getKey();
            if(map1.containsKey(a)){
                b = Math.min(map1.get(a), entry.getValue());
                for(int i=0;i<b;i++){
                    nums1[i+len]=a;
                }
                len+=b;
            }
        }
        int[] result = new int[len];
        System.arraycopy(nums1, 0, result, 0, len);
        return result;
    }
}
