package Algorithms;

/**
 * Created by yuhuazh on 5/16/2016.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] buff = new int[s.length()+1][t.length()+1]; //consider empty substring, so length()+1
        //buff[i][j]: s.substring(0,i) contains how many distinct t.substring(0,j)
        buff[0][0]=1;
        for(int i=1;i<=s.length();i++)
            buff[i][0]=1;
        for(int j=1;j<=t.length();j++)
            buff[0][j]=0;

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                buff[i][j]=buff[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1))
                    buff[i][j]+=buff[i-1][j-1];
            }
        }
        return buff[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        DistinctSubsequences inst  = new DistinctSubsequences();
        System.out.println(inst.numDistinct(s,t));
    }
}
