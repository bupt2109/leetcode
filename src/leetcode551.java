/**
 * Student Attendance Record I
 * Time: 2018-09-19 16:23
 *
 * Input: "PPALLP"
 Output: True
 Example 2:
 Input: "PPALLL"
 Output: False
 */
public class leetcode551 {
    public boolean checkRecord(String s) {
        if(s==null || s.length()<2){
            return true;
        }
        int late = 0;
        int absent = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='L'){
                late ++;
                if(late==3){
                    return false;
                }
            }else{
                late = 0;
                if(ch=='A'){
                    absent ++;
                    if(absent==2){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
