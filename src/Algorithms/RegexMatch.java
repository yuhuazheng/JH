
public class RegexMatch {

	public boolean isMatch(String s, String p) {
		if(p.length()==0) return s.length()==0;
		if(p.length()==1)
			return ( (s.length()==1) && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0)) );
		if(p.charAt(1)=='*'){
			if(isMatch(s,p.substring(2))){
				return true;
			}
			return ( s.length()>0
					 && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))
					 && isMatch(s.substring(1),p));
		}
		else{
			return ( s.length()>0
					 && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))
					 && isMatch(s.substring(1),p.substring(1)));
		}
	}
}
