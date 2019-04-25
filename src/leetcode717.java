/**
 * Created by LYX on 2019/4/25.
 */
public class leetcode717 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length - 1;
        if(bits[len] == 1){
            return false;
        }
        int count = 0;
        while(len>0 && bits[--len] != 0){
            count ++;
        }
        return (count&1)==0;
    }
}
