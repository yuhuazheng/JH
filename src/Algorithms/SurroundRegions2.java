package myPractice;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundRegions2 {

	public void solve(char[][] board) {
		//1. instead of finding "o" inside matrix; finding "o" on the boundary;
		//2. assign "x" to "o" on the boundary and flip back
		
		if(board==null || board.length<=0 || board[0].length<=0){
			return;
		}
		
		//find boundary "o"
		for(int i=0; i<board.length;i++){
			checkBoundary(board,i,0); //first column
			checkBoundary(board,i,board[0].length-1); //last column
		}
		for(int j=0; j<board[0].length;j++){
			checkBoundary(board,0,j); //first row
			checkBoundary(board,board.length-1,j); //last row
		}
		
		//update values for all
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length;j++){
				if(board[i][j]=='#'){
					board[i][j]='O';
				}
				else{
					board[i][j]='X';
				}
			}
		}
	}
	
	public void checkBoundary(char[][] board, int row, int col){
		if(row<0 || row>=board.length || col<0 || col>=board[0].length){
			return;
		}
		if(board[row][col]!='O'){
			return;
		}
		board[row][col]='#';
		Queue<Integer> q = new LinkedList<Integer>();
		int totalidx = row*board[0].length+col;
		q.offer(totalidx);
		while(!q.isEmpty()){
			totalidx=q.poll();
			int i= totalidx/board[0].length;
			int j= totalidx%board[0].length;
			//go 4 directions
			if(i-1>=0 && board[i-1][j]=='O'){
				totalidx = (i-1)*board[0].length+j;
				q.offer(totalidx);
				board[i-1][j]='#';
			}
			if(i+1<board.length && board[i+1][j]=='O'){
				totalidx = (i+1)*board[0].length+j;
				q.offer(totalidx);
				board[i+1][j]='#';
			}
			if(j-1>=0 && board[i][j-1]=='O'){
				totalidx = (i)*board[0].length+j-1;
				q.offer(totalidx);
				board[i][j-1]='#';
			}
			if(j+1<board[0].length && board[i][j+1]=='O'){
				totalidx = (i)*board[0].length+j+1;
				q.offer(totalidx);
				board[i][j+1]='#';
			}
		}
	}
}
