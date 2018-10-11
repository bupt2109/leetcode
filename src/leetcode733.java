import java.util.ArrayList;
import java.util.List;

/**
 *
 * Time: 2018-09-26 14:29
 *
 */
public class leetcode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int h = image.length;
        int w = image[0].length;
        int[][] res = new int[h][w];
        int[][] visit = new int[h][w];
        int oldColor = image[sr][sc];
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                res[i][j] = image[i][j];
            }
        }
        pos.add(sr * 100 + sc);
        while(pos.size()>0){
            int p = pos.get(0);
            int p1 = p / 100;
            int p2 = p % 100;
            res[p1][p2] = newColor;
            pos.remove(0);
            //上
            if(p1-1>=0 && visit[p1-1][p2]==0 && image[p1-1][p2]==oldColor){
                visit[p1-1][p2]=1;
                pos.add((p1-1)*100 + p2);
            }
            //下
            if(p1+1<h && visit[p1+1][p2]==0 && image[p1+1][p2]==oldColor){
                visit[p1+1][p2]=1;
                pos.add((p1+1)*100 + p2);
            }
            //左
            if(p2-1>=0 && visit[p1][p2-1]==0 && image[p1][p2-1]==oldColor){
                visit[p1][p2-1]=1;
                pos.add(p1*100 + p2 - 1);
            }
            //右
            if(p2+1<w && visit[p1][p2+1]==0 && image[p1][p2+1]==oldColor){
                visit[p1][p2+1]=1;
                pos.add(p1*100 + p2 + 1);
            }
        }
        return res;
    }
}
