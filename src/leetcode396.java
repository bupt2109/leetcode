/**
 * Created by YX on 2016/10/25.
 */
/*  ERROR1
input: [-2147483648,-2147483648]
Output: 0
 Expected: -2147483648*/

/*  ERROR2
Last executed input: [

    768,-954,35,-656,999,88,-475,-344,-990,49,-297,464,375,233,-168,791,889,-741,-844,-651,-726,41,-171,
    .....
    .....
]
*/

/*Consider we have 5 coins A,B,C,D,E
        ZZ = SUM(A+B+C+D+E)
        According to the problem statement
        F(0) = (0A) + (1B) + (2C) + (3D) + (4E)
        F(1) = (4A) + (0B) + (1C) + (2D) + (3E)
        F(2) = (3A) + (4B) + (0C) + (1D) + (2E)
        F(3) = (2A) + (3B) + (4C) + (0D) + (1E)
        F(4) = (1A) + (2B) + (3C) + (4D) + (0E)

        F(0) = F(0)
        F(1) = F(0) + 5A - ZZ
        F(2) = F(1) + 5B - ZZ
        F(3) = F(2) + 5C - ZZ
        F(4) = F(3) + 5D - ZZ
        F(i) = F(i-1) + nA[i-1] -ZZ*/


public class leetcode396 {

    public int maxRotateFunction(int[] A) {
        if(A==null || A.length==0)
            return 0;
        int n = A.length,res=0,zz=0,tmp;
        for(int i=0;i<n;i++){
            zz += A[i];
            res += A[i]*i;
        }
        tmp=res;
        for(int i=1;i<n;i++){
            tmp += n*A[i-1] - zz;
            res = Math.max(res,tmp);
        }
        return res;
    }

    //此方法时间复杂度太高，超时O(n*n)
    public int maxRotateFunction1(int[] A) {
        if(A==null)
            return 0;
        int n = A.length,res=Integer.MIN_VALUE;//n<=100000
        for(int i=0;i<n;i++){
            int tmp=0;
            for(int j=0;j<n;j++){
                tmp += A[j]*((j+i)%n);
            }
            res = Math.max(res,tmp);
        }
        return res;
    }

}
