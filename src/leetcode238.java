/**
 * Created by YX on 2016/11/3.
 */
//TODO
    //find a O(1) space solution
public class leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        int[] res = new int[nums.length];
        a[0]=1;
        b[nums.length-1]=1;
        for(int al=1,bl=nums.length-2;al<nums.length;al++,bl--){
            a[al]=nums[al-1]*a[al-1];
            b[bl]=nums[bl+1]*b[bl+1];
        }
        for(int i=0;i<nums.length;i++){
            res[i] = a[i]*b[i];
        }
        return res;
    }
}
