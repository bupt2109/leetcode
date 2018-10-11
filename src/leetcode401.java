import java.util.ArrayList;
import java.util.List;

/**
 * Created by YX on 2016/10/15.
 */
public class leetcode401 {
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> list = new  ArrayList<String>();
        if(num<=0 || num >8)
            return list;
        String[][] hour = {
                {"0:"},
                {"1:","2:","4:", "8:"},
                {"3:","5:","6:","9:","10:"},
                {"7:","11:"},
        };
        String[][] minute = {
                {"00"},
                {"01","02","04", "08","16","32"},
                {"03","05","06","09","10","12","17","18","20","24","33","34","36","40","48"},
                {"07","11","13","14","19","21","22","25","26","28","35","37","38","41","42","44","49","50","52","56"},
                {"15","23","27","29","30","39","43","45","46","51","53","54","57","58"},
                {"31","47","55","59"}
        };
        for(int i=0;i<=3;i++){
            for(int j=0;j<=5;j++){
                if(i+j==num){
                    for(int m=0;m<hour[i].length;m++){
                        for(int n=0;n<minute[j].length;n++){
                            list.add(hour[i][m]+minute[j][n]);
                        }
                    }
                }
            }
        }
        System.out.println(list.toString());
        return list;
    }
}
