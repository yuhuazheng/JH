import java.util.Arrays;

/**
 * Created by yuhua on 26/08/16.
 */
public class PatternMatch {
    public boolean isMatch(String s, String p){
        if((s==null||s.length()==0)&&(p==null||p.length()==0)) return true;
        return DFS(s,0,p,0);
    }

    private boolean DFS(String s, int i, String p, int j){
        if(i>=s.length()&&j>=p.length()) return true;
        if(i>=s.length()||j>=p.length()) return false;

        if(j==p.length()-1){
            return (i==s.length()-1&&s.charAt(i)==p.charAt(j));
        }

        char nxtch = p.charAt(j+1);
        if(nxtch>='a'&&nxtch<='z'){
            return (s.charAt(i)==p.charAt(j)&&DFS(s,i+1,p,j+1));
        }

        char curch = p.charAt(j);
        j+=2;
        int low=0;
        while(p.charAt(j)!=','&&(p.charAt(j)>='0'&&p.charAt(j)<='9')){
            low = low*10+(p.charAt(j)-'0');
            j++;
        }
        j++;
        int hi=0;
        while(p.charAt(j)!=','&&(p.charAt(j)>='0'&&p.charAt(j)<='9')){
            hi = hi*10+(p.charAt(j)-'0');
            j++;
        }
        hi--;
        j++;

        for(int k=low;k<=hi;k++){
            String sub = s.substring(i,i+k);
            char[] chs = new char[k];
            Arrays.fill(chs,curch);
            String ptn = String.valueOf(chs);
            if(sub.equals(ptn)&&DFS(s,i+k,p,j))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcc";
        String p = "a{1,3}b{1,3}cc{1,3}";
        PatternMatch inst = new PatternMatch();
        System.out.println(inst.isMatch(s,p));
    }
}
