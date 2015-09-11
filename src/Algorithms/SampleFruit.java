package Algorithms;

/**
 * Created by yuhua on 8/18/15.
 */
public class SampleFruit {

    // consider a number of fruits and their corresponding probabilities: fruit_probs = {'apple': 0.23, 'pear': 0.11, 'grape': 0.45, 'kiwi': 0.21, ...}
    // problem: write a function/method to sample a single fruit according to its probability

    public static void main(String[] args){
        double[] probs = {0.23,0.11,0.45,0.21};
        double draw = ((0+ (int)(Math.random() * ((100-0)+1)))/100.0);
        System.out.println(draw);
        int index=0;
        double cdf=0.0;
        for(double d: probs){
            cdf+=d;
            if(draw<=cdf){
                System.out.println(index);
                break;
            }
            index++;
        }

    }
}
