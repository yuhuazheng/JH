package Algorithms;

public class PalinPartitionII {

	public int minCut(String s) {
        if(s==null || s.length()<1){
        	return 0;
        }
        
        boolean[][] dict = getDict(s);
        int[] res = new int[s.length()+1]; //how many palin words up to this char
        for(int i=0;i<s.length();i++){
        	res[i+1]=i+1;
        	for(int j=0;j<=i;j++){
        		if(dict[j][i]){
        			res[i+1]=Math.min(res[i+1], res[j]+1);
        		}
        	}
        }
        return res[s.length()]-1; //n words need n-1 cuts
	}
	
	private boolean[][] getDict(String s){
		boolean[][] dict = new boolean[s.length()][s.length()];
		for(int i=s.length()-1;i>=0;i--){
			for(int j=i;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j) && (i+1>j-1 || dict[i+1][j-1])){
					dict[i][j]=true;
				}
			}
		}
		return dict;
	}
}
