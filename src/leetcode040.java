import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Time: 2018-09-20 19:56
 * Copyright (C) 2018
 */
public class leetcode040 {

    public boolean hhhh(int[] nums, int total) {
        if (nums == null || nums.length == 0 || total < 0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        return get(nums, total, 0, list);
    }

    private boolean get(int[] nums, int total, int i, List<Integer> list) {
        if (i > nums.length || total < 0) {
            return false;
        }
        if (total == 0) {
            return true;
        }
        for (int p = i; p < nums.length; p++) {
            list.add(nums[p]);
            boolean a =  get(nums, total - nums[p], p+1, list);
            if(a){
                return true;
            }
            list.remove(list.size()-1);
            while (p < nums.length - 1 && nums[p] == nums[p+1]) p++;
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode040 l40 = new leetcode040();
        int[] aa = {20,55,30,60,75,55};
        boolean a = l40.hhhh(aa,100);
        System.out.println(a);
    }
}
