/**
 * Created by yuhua on 21/06/16.
 */
public class WildCardMatchDP {
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

        boolean[][] buf = new boolean[p.length()+1][s.length()+1]; //buf[i][j] p->i can match s->j
        buf[0][0]=true;
        if(p.charAt(0)=='*'){
            for(int j=0;j<=s.length();j++){
                buf[1][j]=true;
            }
        }

        for(int i=1;i<=p.length();i++){
            for(int j=1;j<=s.length();j++){
                if(p.charAt(i-1)=='*'){
                    for(int k=j;k<=s.length();k++){
                        if(buf[i-1][k-1]||buf[i][k-1]||buf[i-1][k]) {
                            buf[i][k] = true;
                            if(buf[i-1][k-1]) //* is posterior
                                buf[i][k - 1] = true;
                        }
                    }
                }
                else if(p.charAt(i-1)=='?'){
                    if(buf[i-1][j-1])
                        buf[i][j]=true;
                }
                else{
                    if(buf[i-1][j-1]&&p.charAt(i-1)==s.charAt(j-1))
                        buf[i][j]=true;
                }
            }
        }
        return buf[p.length()][s.length()];
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
        String s = "b";
        String p = "?*?";
        WildCardMatchDP inst = new WildCardMatchDP();
        System.out.println(inst.isMatch(s,p));
    }
}

