/**
 * Created by yuhuazh on 6/17/2016.
 */
public class InterleavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null&&s2==null&&s3==null) return true;
        if(s1==null||s2==null||s3==null) return false;
        if(s1.length()==0&&s2.length()==0&&s3.length()==0) return true;
        if(s1.length()+s2.length()!=s3.length()) return false;


        int len1=s1.length();
        int len2=s2.length();
        boolean[][] valid = new boolean[len1+1][len2+1];//len1 of s1 + len2 of s2 is valid for s3
        valid[0][0]=true;
        for(int i=0;i<len1;i++){
            if(s1.charAt(i)==s3.charAt(i))
                valid[i+1][0]=true;
            else
                break;
        }
        for(int j=0;j<len2;j++){
            if(s2.charAt(j)==s3.charAt(j))
                valid[0][j+1]=true;
            else
                break;
        }

        for(int i=0;i<len1;i++){
            char c1=s1.charAt(i);
            for(int j=0;j<len2;j++){
                char c2=s2.charAt(j);
                char c3=s3.charAt(i+j+1);
                if(c1==c3){
                    valid[i+1][j+1]= valid[i+1][j+1] || valid[i][j+1];
                }
                if(c2==c3){
                    valid[i+1][j+1] = valid[i+1][j+1] || valid[i+1][j];
                }
            }
        }
        return valid[len1][len2];
    }

    public static void main(String[] args) {
        String s1="a";
        String s2="b";
        String s3="ab";
        InterleavingStrings inst = new InterleavingStrings();
        System.out.println(inst.isInterleave(s1,s2,s3));
    }
}
