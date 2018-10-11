/**
 * Created by YX on 2016/10/19.
 */
public class leetcode413 {
    public int cac(int len){
        if(len<3)
            return 0;
        return (len-1)*(len-2)/2;
    }

    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3)
            return 0;
        int total=0,diff= A[1]-A[0],index1=0,index2=1;
        for(int i=2;i<A.length;i++){
            if(diff!=(A[i]-A[i-1])){
                total+=cac(index2-index1+1);
                index1 = index2;
                index2++;
                diff = (A[i]-A[i-1]);
            }
            else{
                index2++;
            }
        }
        total+=cac(index2-index1+1);
        return total;
    }
}
