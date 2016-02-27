package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhua on 2/27/16.
 */
public class ValidateSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board == null) return false;
        if (board.length != 9 || board[0].length != 9) return false;

        boolean[] validRow = new boolean[9];
        boolean[][] validCol = new boolean[9][9];
        boolean[][] validSub = new boolean[9][9];

        for (int i = 0; i < 9; i++) { //row
            Arrays.fill(validRow, false);
            //col and sub
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.') continue;
                int v = board[i][j] - '1';
                if (!isValid(validRow, v)
                        || !isValid(validCol[j], v)
                        || !isValid(validSub[i/3*3+j/3],v)
                        )
                    return false;
            }
        }
        return true;
    }

    public boolean isValid(boolean[] existed, int v){
        if(existed[v]) return false;
        existed[v]=true;
        return true;
    }
}
