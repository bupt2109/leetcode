/**
 * Author: Peak Index in a Mountain Array
 * Time: 2018-09-19 11:07
 * Let's call an array A a mountain if the following properties hold:

 A.length >= 3
 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

 Example 1:

 Input: [0,1,0]
 Output: 1
 Example 2:

 Input: [0,2,1,0]
 Output: 1
 Note:

 3 <= A.length <= 10000
 0 <= A[i] <= 10^6
 A is a mountain, as defined above.
 */
public class leetcode852 {

    public static void main(String[] args) {
        leetcode852 a = new leetcode852();
        int[] b = {0,1,2,1,0,-1,-2,-3};
        System.out.println(a.peakIndexInMountainArray(b));
    }

    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1, middle = 0;
        while(left <= right){
            middle = (right+left)/2;
            if(A[middle] > A[middle-1]){//上
                if(A[middle] > A[middle+1]){//上下
                    return middle;
                }else{//上上
                    left = middle;
                }
            }else{//下下
                right = middle;
            }
        }
        return middle;
    }
}
