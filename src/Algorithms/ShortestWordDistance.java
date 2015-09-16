package Algorithms;

/**
 * Created by yuhuazh on 9/13/2015.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words==null || words.length<2) return 0;
        int idx1=-1;
        int idx2=-1;
        int dist=Integer.MAX_VALUE;

        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                idx1=i;
                if(idx2>=0){
                    dist=Math.min(dist,idx1-idx2);
                }
            }
            if(words[i].equals(word2)){
                idx2=i;
                if(idx1>=0){
                    dist=Math.min(dist,idx2-idx1);
                }
            }
        }
        return dist;
    }
}
