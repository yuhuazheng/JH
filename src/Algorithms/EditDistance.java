package Algorithms;

/**
 * Created by yuhuazh on 5/17/2016.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] buff = new int[m+1][n+1]; //edit distance til ith and jth chars
        buff[0][0]=0;
        for(int i=1;i<=m;i++)
            buff[i][0]=i;
        for(int j=1;j<=n;j++)
            buff[0][j]=j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    buff[i][j]=buff[i-1][j-1];
                }
                else{
                    buff[i][j]=1+Math.min(Math.min(buff[i-1][j],buff[i][j-1]),buff[i-1][j-1]);
                }
            }
        }
        return buff[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcd";
        EditDistance inst = new EditDistance();
        System.out.println(inst.minDistance(s1,s2));
    }
}
