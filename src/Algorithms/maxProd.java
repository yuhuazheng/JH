package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 1/4/2016.
 */
public class maxProd {
    public static void main(String[] args) {
        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
        maxProd inst = new maxProd();
        System.out.println(inst.maxProduct(words));
    }

    public int maxProduct(String[] words) {
        if(words==null||words.length<2) return 0;
        Arrays.sort(words, (w1, w2) -> w2.length()-w1.length());
        int n = words.length;

        //encode words
        int[] code = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                code[i]|= 1<<(words[i].charAt(j)-'a');
            }
        }

        //n^2 search
        int len=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((code[i]&code[j])==0){
                    len = Math.max(len,words[i].length()*words[j].length());
                }
            }
        }
        return len;
    }
}
