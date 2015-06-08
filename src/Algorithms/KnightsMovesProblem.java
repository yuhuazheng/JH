package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Use recursive and backtracking to find solutions for knight moves problem
 * @author yuhuazh
 *
 */
public class KnightsMovesProblem {

	public static void main(String[] args){
		int m=4;
		int n=5;
		int len=9; //9,15,31
		List<String> res = new ArrayList<String>();
		int[] count = new int[1];
		
		keyboard keybd = new keyboard(m,n);
		//set vowels
		keybd.setOneCell(0, 0, 1); //a
		keybd.setOneCell(0, 4, 1); //e
		keybd.setOneCell(1, 3, 1); //i
		keybd.setOneCell(2, 4, 1); //o
		keybd.setOneCell(3, 0, -1); 
		keybd.setOneCell(3, 4, -1); 
		
		for(int i=0;i<keybd.getRowNum();i++){
			for(int j=0;j<keybd.getColNum();j++){
				System.out.print(keybd.getOneCell(i, j));
				System.out.print(",");
			}
			System.out.println();
		}
		
		KnightsMovesProblem onSol = new KnightsMovesProblem();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(keybd.getOneCell(i, j)>=0){
					StringBuilder item = new StringBuilder();
					onSol.moveOneStep(keybd,i,j,len,count,item,res);
				}
			}
		}
		System.out.println(res.size()); //actually "res" also contains all moves step by step
	}
	
	//starting from position (i,j), move one step from remained "len" steps,
	private void moveOneStep(keyboard keybd,int i,int j, int len, int[] count, StringBuilder item, List<String> res){
		int m = keybd.getRowNum();
		int n = keybd.getColNum();
		
		if( len==0 && (i>=0&&i<m) && (j>=0&&j<n) && (keybd.getOneCell(i, j)==0 || (keybd.getOneCell(i, j)==1&&count[0]<2)) ){
			//finished all steps and found a solution
			item.append(i); 
			item.append(j); 
			item.append(",");
			res.add(item.toString());
			//System.out.println(item.toString());
			item.setLength(item.length()-3);
			return;
		}
		
		if((i>=0&&i<m) && (j>=0&&j<n) && keybd.getOneCell(i, j)>=0){
			if(keybd.getOneCell(i, j)==1){
				if(count[0]<2){
					count[0]++;
				}
				else{
					return;
				}
			}
			item.append(i); 
			item.append(j); 
			item.append(",");
						
			moveOneStep(keybd,i-2,j-1,len-1,count,item,res);
			moveOneStep(keybd,i-2,j+1,len-1,count,item,res);
			moveOneStep(keybd,i+2,j-1,len-1,count,item,res);
			moveOneStep(keybd,i+2,j+1,len-1,count,item,res);
			moveOneStep(keybd,i-1,j-2,len-1,count,item,res);
			moveOneStep(keybd,i-1,j+2,len-1,count,item,res);
			moveOneStep(keybd,i+1,j-2,len-1,count,item,res);
			moveOneStep(keybd,i+1,j+2,len-1,count,item,res);
			
			//backtracking
			item.setLength(item.length()-3);
			if(keybd.getOneCell(i, j)==1){
				count[0]--;
			}
		}
		return;
	}
	
}

class keyboard{
	private int[][] map; //map to hold the keys. 0:normal digit or letter, 1:vowel, -1:invalid
	
	public keyboard(int m,int n){
		map = new int[m][n];
	}
	
	public int getRowNum(){
		if(map!=null && map.length>0) return map.length;
		return 0;
	}
	
	public int getColNum(){
		if(map!=null && map.length>0 && map[0].length>0) return map[0].length;
		return 0;
	}
	
	public void setOneCell(int m, int n, int v){
		map[m][n]=v;
	}
	
	public int getOneCell(int m, int n){
		return map[m][n];
	}
}