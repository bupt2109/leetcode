import java.util.HashSet;
import java.util.Set;

/**
 * Distribute Candies
 * Time: 2018-09-30 16:18
 *
 */
public class leetcode575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int candy : candies){
            set.add(candy);
        }
        if(set.size() > candies.length/2){
            return candies.length/2;
        }else{
            return set.size();
        }
    }

}
