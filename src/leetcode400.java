/**
 * Created by YX on 2016/10/14.
 */
public class leetcode400 {
    public int findNthDigit(int n) {
        int index=0;
        int[] area = {0,9,189,2889,38889,488889,5888889,68888889,788888889,2147483647};
        int begin=1;
        int shang,yu,res;
        while(index<=8){
            if(n>area[index]&&n<=area[index+1])
                break;
            begin*=10;
            index++;
        }
        shang = (n-area[index]-1)/(index+1);
        yu = index-(n-area[index]-1)%(index+1);
        res = begin+shang;
        for(int i=1;i<=yu;i++){
            res /= 10;
        }
        return res%=10;
    }
}
