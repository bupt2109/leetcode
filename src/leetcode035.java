/**
 * Created by LYX on 2019/4/24.
 */
public class leetcode035 {
    //TODO
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length, middle;
        while(start < end){
            middle = start + (end-start)/2;
            if(target == nums[middle]){
                return middle;
            }else if(target < nums[middle]){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        System.out.println(start + "," + end);
        return 1;
    }

    public static void main(String[] args) {
        leetcode035 test = new leetcode035();
        int[] test1 = {1,3,5,6};
        System.out.println("0 " + test.searchInsert(test1, 0));
        System.out.println("1 " + test.searchInsert(test1, 1));
        System.out.println("2 " + test.searchInsert(test1, 2));
        System.out.println("3 " + test.searchInsert(test1, 3));
        System.out.println("4 " + test.searchInsert(test1, 4));
        System.out.println("5 " + test.searchInsert(test1, 5));
        System.out.println("6 " + test.searchInsert(test1, 6));
        System.out.println("7 " + test.searchInsert(test1, 7));
    }
}
