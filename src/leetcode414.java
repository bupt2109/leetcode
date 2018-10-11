/**
 * Created by YX on 2016/10/21.
 */
/*Submission Result: Wrong Answer
        Input: [1,2,-2147483648]
        Output: 2
        Expected: -2147483648*/
//-2147483648,-2147483648,-2147483648,-2147483648,1,1,1
//1,1.2
public class leetcode414 {
    public int thirdMax(int[] nums) {
        int max1, max2, max3,count=0,flag=0;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if(num == Integer.MIN_VALUE){
                flag=1;
                continue;
            }
            if (num == max1 || num == max2)
                continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
            count++;
            //System.out.println(max1 + " " + max2 + " " + max3+" "+count);
        }
        count+=flag;
        if(count>=3)
            return max3;
        else {
            return max1;
        }
    }

    /*public static void main(String[] args) {
        int[] nums={-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
        leetcode414 test = new leetcode414();
        System.out.println(test.thirdMax(nums));
    }*/
}
