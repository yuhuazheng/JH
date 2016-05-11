package Algorithms;

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
		if (n <= 0) return res;
		if (n == 1) {
			List<String> temp = new ArrayList<>();
			temp.add("Q");
			res.add(temp);
			return res;
		}

		boolean[] usedCol = new boolean[n];
		int[] item = new int[n];
		Arrays.fill(item,-1);
		helper(0, usedCol, item, res);
		return res;
	}

	//add kth row
	private void helper(int k, boolean[] usedCol, int[] item, List<List<String>> res) {
		int n = usedCol.length;
		if (k == n) {
			//a valid solution
			List<String> oneSol = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				char[] oneRow = new char[n];
				Arrays.fill(oneRow, '.');
				oneRow[item[i]] = 'Q';
				oneSol.add(new String(oneRow));
			}
			res.add(oneSol);
			return;
		}

		//update kth row
		for (int i = 0; i < n; i++) {
			if (!isValid(k,i, usedCol, item))
				continue;
			item[k] = i;
			usedCol[i] = true;
			helper(k + 1, usedCol, item, res);
			usedCol[i] = false;
			item[k] = -1;
		}
	}

	private boolean isValid(int k, int i, boolean[] usedCol,int[] item) {
		//if valid at kth row, ith col
		if (usedCol[i])
			return false;
		for (int r = 0; r < k; r++) {
			if (Math.abs(k - r) == Math.abs(i - item[r]))
				return false;
		}
		return true;
	}

}
