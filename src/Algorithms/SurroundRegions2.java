
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
			BFS(board,i,0); //first column
			BFS(board,i,board[0].length-1); //last column
		}
		for(int j=0; j<board[0].length;j++){
			BFS(board,0,j); //first row
			BFS(board,board.length-1,j); //last row
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

	public void BFS(char[][] board, int row, int col){
		if(row<0 || row>=board.length || col<0 || col>=board[0].length){
			return;
		}
		if(board[row][col]=='X'|| board[row][col]=='#'){
			return;
		}
		board[row][col]='#';
		BFS(board,row-1,col);
		BFS(board,row+1,col);
		BFS(board,row,col-1);
		BFS(board,row,col+1);
	}

	public static void main(String[] args){
		char[][] board = {
				{'O','O'},
				{'O','O'}
		};

		SurroundRegions2 helper = new SurroundRegions2();
		helper.solve(board);

		//assume for square
		int sizeC = board[0].length;
		int sizeR = board.length;

		for(int i=0; i<sizeR; i++){
			for(int j=0; j<sizeC; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
