/**
 * Created by YX on 2016/11/3.
 */
public class leetcode268 {
    public int missingNumber(int[] nums) {
        int n = nums.length+1;
        int total=0;
        for(int num:nums){
            total+=num;
        }
        return  n*(n+1)/2-total;
    }
}
