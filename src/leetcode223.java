/**
 * Created by YX on 2016/11/2.
 */
public class leetcode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A) * (D-B);
        int area2 = (G-E) * (H-F);
        int overlap = 0;
        int left,right,up,down;
        left = Math.max(A,E);
        right = Math.min(C,G);
        up = Math.min(D,H);
        down = Math.max(B,F);
        if(left<right && up>down)
            overlap = (up-down) * (right-left);
        return area1+area2-overlap;
    }
}
