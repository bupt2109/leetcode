/**
 * 905. Sort Array By Parity
 * Time: 2018-09-19 11:50
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

 You may return any answer array that satisfies this condition.

 Example 1:
 Input: [3,1,2,4]
 Output: [2,4,3,1]
 The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


 Note:
 1 <= A.length <= 5000
 0 <= A[i] <= 5000

 */
public class leetcode905 {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int even = 0, odd = A.length-1;
        for(int i : A){
            if((i & 1) == 1){//odd
                res[odd--] = i;
            }else{//even
                res[even++] = i;
            }
        }
        return res;
    }
}
