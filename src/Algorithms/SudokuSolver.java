/**
 * Created by yuhua on 17/08/16.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean[][] visitedRow = new boolean[9][9];
        boolean[][] visitedCol = new boolean[9][9];
        boolean[][] visitedCell = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=board[i][j];
                if(c!='.'){
                    int v = c-'0';
                    visitedRow[i][v-1]=true;
                    visitedCol[j][v-1]=true;
                    visitedCell[(i/3)*3+j/3][v-1]=true;
                }
            }
        }

        DFS(board,visitedRow,visitedCol,visitedCell,0,0);
    }

    private boolean DFS(char[][] board, boolean[][] visitedRow,boolean[][] visitedCol, boolean[][] visitedCell, int i, int j){
        System.out.println("test "+i+" "+j);
        if(i==9) {
            System.out.println("found");
            return true;
        }
        char c=board[i][j];
        if(c=='.'){
            char[] chs = {'1','2','3','4','5','6','7','8','9'};
            for(int k=1;k<=9;k++){
                if(visitedRow[i][k-1]||visitedCol[j][k-1]||visitedCell[(i/3)*3+j/3][k-1]){
                    continue;
                }
                else{
                    System.out.println("try "+i+" "+j+" with "+k);
                    board[i][j]=chs[k-1];
                    visitedRow[i][k-1]=true;
                    visitedCol[j][k-1]=true;
                    visitedCell[(i/3)*3+j/3][k-1]=true;
                    int nj=j+1==9?0:j+1;
                    int ni=nj==0?i+1:i;
                    if(DFS(board,visitedRow,visitedCol,visitedCell,ni,nj))
                        return true;
                    visitedCell[(i/3)*3+j/3][k-1]=false;
                    visitedCol[j][k-1]=false;
                    visitedRow[i][k-1]=false;
                    board[i][j]='.';
                }
            }
            System.out.println("failed at "+i+" "+j);
            return false;
        }
        else{
            System.out.println("occupied");
            int nj=j+1==9?0:j+1;
            int ni=nj==0?i+1:i;
            return DFS(board,visitedRow,visitedCol,visitedCell,ni,nj);
        }
    }

    public static void main(String[] args) {
        String[] s ={"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char[][] board = new char[9][9];
        for(int i=0;i<9;i++){
            board[i]=s[i].toCharArray();
        }
        SudokuSolver inst = new SudokuSolver();
        inst.solveSudoku(board);
        System.out.println("finished");
    }
}
