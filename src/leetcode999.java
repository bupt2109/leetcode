/**
 * Created by LYX on 2019/4/24.
 */
public class leetcode999 {
    public int numRookCaptures(char[][] board) {
        int res = 0;
        int len = board.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(board[i][j] == 'R'){
                    int val = i * len + j;
                    int[] vals = {val - len, val + len, val - 1, val + 1};
                    int[] diff = {-len, len, -1, 1};
                    int[] count = {i, len - i - 1, j, len - j - 1};
                    int tmpVal;
                    for (int k = 0; k < 4; k++) {
                        tmpVal = vals[k];
                        for (int l = 0; l < count[k]; l++) {
                            char ch = board[tmpVal/len][tmpVal%len];
                            if(ch=='p'){
                                res ++;
                                break;
                            }else if(ch=='B'){
                                break;
                            }
                            tmpVal += diff[k];
                        }
                    }
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode999 test = new leetcode999();
        char[][] board = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','p'},
                {'.','.','.','.','.','.','.','p'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        System.out.println(test.numRookCaptures(board));
    }
}
