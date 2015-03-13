package Algorithms;

import java.util.ArrayList;

public class Permutation2 {

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(num==null || num.length==0)
	        return res;
	    helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
	    return res;
	}
	//this parameter passing is efficient than returning a new ArrayList<Integer>, which will need more space
	
	private void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res)
	{
	    if(item.size() == num.length)
	    {
	        res.add(new ArrayList<Integer>(item)); //only create new list and add to res when it has length.
	        return;
	    }
	    for(int i=0;i<num.length;i++)
	    {
	        if(!used[i])
	        {
	            used[i] = true;
	            item.add(num[i]);
	            helper(num, used, item, res);
	            item.remove(item.size()-1);
	            used[i] = false;
	        }
	    }
	}
}
