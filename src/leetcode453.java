/**
 * Created by YX on 2016/11/8.
 */
public class leetcode453 {
    public int minMoves(int[] nums) {
        int len = nums.length;
        int max,min;
        long total;
        max=min=nums[0];
        total = nums[0];
        for(int i=1;i<len;i++){
            total+=nums[i];
            if(nums[i]>max){
                max=nums[i];
            }
            else if(nums[i]<min){
                min=nums[i];
            }
        }
        int tmp = ((int)(total%len)-max+min)%len;
        System.out.println(tmp);
        for(int i=0;i<Integer.MAX_VALUE;i++){
            if((tmp+i)%len==0){
                tmp=i;
                break;
            }
        }
        return max-min + tmp;
    }

    public static void main(String[] args) {
        leetcode453 test = new leetcode453();
        //int [] a = {1,1,Integer.MAX_VALUE};
        int [] a = {1,1,2,3,4,5,Integer.MAX_VALUE};
        System.out.println(test.minMoves(a));
    }
}
