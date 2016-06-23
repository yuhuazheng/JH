/**
 * Created by yuhua on 21/06/16.
 */
public class WildCardMatch {
    public boolean isMatch(String s, String p) {
        if(s==null||s.length()==0) return p==null||p.length()==0|| isAllStar(p);
        if(p.length()==0) return s.length()==0;
        if(p.length()==1){
            if(p.charAt(0)=='*')
                return true;
            else if(p.charAt(0)=='?')
                return s.length()==1;
            else
                return s.length()==1&&p.charAt(0)==s.charAt(0);
        }

        if(p.charAt(0)=='*'){
            for(int i=0;i<=s.length()-1;i++){
                if(isMatch(s.substring(i),p.substring(1)))
                    return true;
            }
            return false;
        }
        else if(p.charAt(0)=='?'){
            return isMatch(s.substring(1),p.substring(1));
        }
        else{
            return p.charAt(0)==s.charAt(0)&&isMatch(s.substring(1),p.substring(1));
        }
    }

    private boolean isAllStar(String s){
        if(s==null||s.length()==0) return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='*')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        String p = "a*******b";
        WildCardMatch inst = new WildCardMatch();
        System.out.println(inst.isMatch(s,p));
    }
}
