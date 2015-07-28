package Algorithms;

public class SudokuValidate {

	public static void main(String[] args){
		char[][] board = null;//{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		System.out.println(isValidSudoku(board)?"true":"false");
		
	}
	
	public static boolean isValidSudoku(char[][] board) {
		if(board==null){
			return false;
		}
		
        if(board.length!=9 || board[0].length!=9){
        	return false;
        }
        
        //check row
        for(int i=0;i<9;i++){
        	char[] row = board[i];
        	if(!isValid(row)){
        		return false;
        	}
        }
        
        //check column
        for(int j=0; j<9; j++){
        	char[] col = new char[9];
        	for(int k=0;k<9;k++){
        		col[k]=board[k][j];
        	}
        	if(!isValid(col)){
        		return false;
        	}
        }
        
        //check box
        for(int m=0; m<3; m++){
        	for(int n=0;n<3;n++){
        		char[] box = new char[9];
        		int idx=0;
        		for(int s=m*3;s<(m+1)*3; s++){
        			for(int t=n*3;t<(n+1)*3;t++){
        				box[idx++]=board[s][t];
        			}
        		}
        		if(!isValid(box)){
        			return false;
        		}
        	}
        }
        
        return true;
    }
	
	//check a given char array
	private static boolean isValid(char[] block){
		boolean[] existed = new boolean[9];
		for(char c:block){
			if(c=='.'){
				continue;
			}
			if( !(c>='1'&& c<='9') || existed[c-'1'] ){
				return false;
			}
			existed[c-'1']=true; //check duplication
		}
		return true;
	}
}
