import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by YX on 2016/11/16.
 */
public class niu20161116 {
    final String[] path = {
            "1/velflux_1110.txt",
            "1/velflux_1111.txt",
            "1/velflux_1112.txt",
            "1/velflux_1113.txt",
            "1/velflux_1114.txt"
    };
    String[] array = new String[720*5];
    String[] a = new String[720*3];
    String[] b = new String[720];

    public void readdatafromfile(){
        for(int i=0;i<5;i++) {
            File file = new File(path[i]);
            StringBuilder result = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String s = null;
                while ((s = br.readLine()) != null) {
                    System.arraycopy(s.split(","),0,array,720*i,720);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readdata() {
        for(int i=0;i<2;i++) {
            System.arraycopy(array, i * 720, a, 0, 720 * 3);
            System.arraycopy(array, (i+3) * 720, b, 0, 720);
        }
    }
}
