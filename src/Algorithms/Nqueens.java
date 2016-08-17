
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens {

	public static void main(String[] args){
		Nqueens inst = new Nqueens();
		List<List<String>> res = inst.solveNQueens(4);
		System.out.println(res.size());
	}
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		if(n<=0) return res;
		if(n==1){
			List<String> temp = new ArrayList<>();
			temp.add("Q");
			res.add(temp);
			return res;
		}

		int[] item = new int[n];
		Arrays.fill(item,-1);
		DFS(n,0,item,res);
		return res;
	}

	private void DFS(int n, int row, int[] item, List<List<String>> res){
		if(row>=n){
			List<String> r = new ArrayList<>();
			for(int i=0;i<n;i++){
				char[] chs = new char[n];
				Arrays.fill(chs,'.');
				chs[item[i]]='Q';
				r.add(String.valueOf(chs));
			}
			res.add(r);
			return;
		}

		for(int i=0;i<n;i++){
			boolean valid=true;
			if(row>0){
				for(int k=0;k<row;k++){
					if(item[k]==i||Math.abs(row-k)==Math.abs(i-item[k])){
						valid=false;
						break;
					}
				}
			}
			if(!valid) continue;
			item[row]=i;
			DFS(n,row+1,item,res);
			item[row]=-1;;
		}
	}

}
