package myPractice;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	public static void main(String[] args){
		char[][] board = {
				{'O','O','O'},
				{'O','O','O'},
				{'O','O','O'}
				};
		
		SurroundedRegions helper = new SurroundedRegions();
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
	
	public void solve(char[][] board) {
        if(board==null || board.length<1 || board[0]==null || board[0].length<1){
        	return;
        }
        int sizeC = board[0].length;
		int sizeR = board.length;
        
        //start from boundary; find connected neighbors via BFS, until no further
        //check top and bottom rows
        for(int j=0; j<sizeC; j++){
        	UpdateBoard(board, 0, j);
        	UpdateBoard(board, sizeR-1, j);
        }
        //check most-left/right column
        for(int j=0; j<sizeR; j++){
        	UpdateBoard(board, j, 0);
        	UpdateBoard(board, j, sizeC-1);
        }
        
        //flip
        for(int m=0; m<sizeR;m++){
        	for(int n=0; n<sizeC; n++){
        		if(board[m][n]=='O'){
        			board[m][n]='X';
        		}
        		if(board[m][n]=='#'){
        			board[m][n]='O';
        		}
        	}
        }
    }
	
	public void UpdateBoard(char[][] board, int i, int j){
        if(board[i][j]!='O'){
        	return;
        }
        int sizeC = board[0].length;
		int sizeR = board.length;
        
        board[i][j]='#';
        Point p = new Point(i,j);
		//all 0-> x, unless it's marked as '#'
        Queue<Point> candidates = new LinkedList<Point>();
        candidates.offer(p);
        
        //BFS
        Point cur = new Point();
        while(!candidates.isEmpty()){
        	cur = candidates.poll();
        	//check neighbors
        	for(int m=cur.row-1; m<=cur.row+1; m=m+2){
        		Point q = new Point(m,cur.col);
        		if( WithinBoard(q,sizeR,sizeC) && board[m][cur.col]=='O'){
        				board[m][cur.col]='#';
        				candidates.add(q);
        			}
        	}
        	for(int n=cur.col-1; n<=cur.col+1; n=n+2){
        		Point q = new Point(cur.row,n);
        		if( WithinBoard(q,sizeR,sizeC) && board[cur.row][n]=='O'){
        				board[cur.row][n]='#';
        				candidates.add(q);
        			}
        	}
        }
        return;
	}
	
	public boolean WithinBoard(Point p, int sizeR, int sizeC){
		if ( (p.row>=0&&p.row<sizeR) && (p.col>=0&&p.col<sizeC) ){
			return true;
		}
		return false;
	}
	
	class Point{
		int row;
		int col;
		
		public Point(){row=0;col=0;}
		public Point(int a,int b){row=a;col=b;}
	}
}
