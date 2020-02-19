import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Leetcode0349
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 349. Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.
 Example 1:
 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]

 Example 2:
 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 *
 * @author yu
 * @version v1.0
 * @Topic: @HashMap @Two Pointers @Binary Search @Sort
 * @Description 找两个数组交集，结果集元素不重复
 * @Date 2020/2/19
 */
public class Leetcode0349 {

    /**
     * 一个hashMap存一个数组，再遍历第二个数组看是不是有，用value是否=1去重
     * O(N)
     * 200219 Accepted	2 ms	39.8 MB https://leetcode.com/submissions/detail/304691232/
     *
     *
     *
     * 其他方法如：排序后（O(NlogN)）
     * 1.两个数组同时走，双指针（N）。
     * 2.二分查找遍历（NlogN）
     * https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, 0);
        }
        int[] res = new int[nums1.length];
        int count = 0;
        for(int num: nums2){
            if(map.containsKey(num)){
                if(map.get(num)==0){
                    res[count ++] = num;
                    map.put(num, 1);
                }
            }
        }
        res = Arrays.copyOf(res, count);
        return res;
    }



    /**
     * 3年前 https://leetcode.com/submissions/detail/63244224/
     * 两个hashset，然后遍历判断
     */
    public int[] intersection3Year(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }
        Iterator<Integer> i = set2.iterator();//先迭代出来
        int len=0,tmp;
        while(i.hasNext()){//遍历
            tmp=i.next();
            if(set1.contains(tmp)){
                nums1[len++]=tmp;
            }
        }
        int[] result = new int[len];
        System.arraycopy(nums1, 0, result, 0, len);
        return result;
    }

}
