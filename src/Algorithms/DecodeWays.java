package Algorithms;

public class DecodeWays {

	public static void main(String[] agrs){
		DecodeWays helper = new DecodeWays();
		String s="01";
		System.out.println(helper.numDecodings(s));
	}
	
	public int numDecodings(String s) {
	    if(s==null || s.length()<1){
	    	return 0;
	    }
	    if(s.length()==1){
	    	if(s.charAt(0)>'0'&&s.charAt(0)<='9'){
	    		return 1;
	    	}
	    	else{
	    		return 0;
	    	}
	    }
	    if(s.charAt(0)<='0'||s.charAt(0)>'9'){
	    	return 0;
	    }
	    
	    int curMinus2=1;
	    int curMinus1=1;
	    int cur=0;
	    char[] chs=s.toCharArray();
	    for(int i=1;i<chs.length;i++){
	    	if(chs[i]<'0'||chs[i]>'9'){
	    		return 0;
	    	}
	    	cur=0;
	    	if((chs[i-1]=='1'&& chs[i]>='0'&& chs[i]<='9')
	    	    || (chs[i-1]=='2'&&chs[i]>='0'&&chs[i]<='6')){
	    		cur=curMinus2;
	    	}
	    	if(chs[i]>='1'&&chs[i]<='9'){
	    		cur+=curMinus1;
	    	}
	    	
	    	curMinus2=curMinus1;
	    	curMinus1=cur;
	    }
	    return cur;
	}
}
