
public class WordSearch {

	public boolean exist(char[][] board, String word) {
		if(board==null || board.length<=0 || board[0].length<=0 || word==null || word==""){
			return false;
		}
		
		boolean[][] used = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length;i++){
			for(int j=0; j<board[0].length; j++){
				if(searchFromCurChar(board,word,0,i,j,used)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean searchFromCurChar(char[][] board, String word, int idx, int row, int col, boolean[][] used){
		if(idx==word.length()){
			return true;
		}
		char curC = word.charAt(idx);
		if(row<0|| col<0 || row>=board.length || col>=board[0].length || board[row][col]!=curC){
			return false;
		}
		
		used[row][col]=true; //backpack used[][], only set when going further on depth
		boolean res = searchFromCurChar(board,word,idx+1,row-1,col,used)
				     || searchFromCurChar(board,word,idx+1,row+1,col,used)
				     || searchFromCurChar(board,word,idx+1,row,col-1,used)
				     || searchFromCurChar(board,word,idx+1,row,col+1,used);
		used[row][col]=false; //reset used[][], when go back from this depth.
		return res;
	}
}
