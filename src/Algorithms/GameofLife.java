package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 10/4/2015.
 */
public class GameofLife {

    public static void main(String[] args){
        int[][] board = {{1,1},
                         {1,0}};
        GameofLife inst = new GameofLife();
        inst.gameOfLife(board);
        for(int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[0]));
        }
    }

    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0||board[0].length==0) return;

        int row=board.length;
        int col=board[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                computeLive(board,i,j);
            }
        }

        //lower bit store current, higher bit store next
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j]=board[i][j]>>1;
            }
        }

    }

    private void computeLive(int[][]board,int i,int j){
        int live=0;
        int dead=0;
        for(int s=i-1;s<=i+1;s++){
            for(int t=j-1;t<=j+1;t++){
                if(s<0||s>=board.length||t<0||t>=board[0].length||(s==i&&t==j))
                    continue;
                //only look at lower bit
                if((board[s][t]&1)==1)
                    live++;
                else
                    dead++;
            }
        }
        //apply rules
        if(live<1 || live>3){
            board[i][j]&=1;
        }
        else if( ((board[i][j]&1)==1) && (live==2||live==3)){
            board[i][j]|=2;
        }
        else if( ((board[i][j]&1)==0) && live==3){
            board[i][j]|=2;
        }
    }
}
