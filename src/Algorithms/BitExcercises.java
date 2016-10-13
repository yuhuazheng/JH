/**
 * Created by yuhua on 12/10/16.
 */
public class BitExcercises {

    public static void main(String[] args) {
        BitExcercises inst = new BitExcercises();
        System.out.println(inst.ModPowOf2(77,64));
        System.out.println(inst.rightPropagate(80));
        System.out.println(inst.isPowOf2(6));
        System.out.println(inst.isPowOf2(8));
    }

    public int ModPowOf2(int num1, int num2){
        return num1&(num2-1);
    }

    public int rightPropagate(int num){
        return num|(num-1);
    }

    public boolean isPowOf2(int num){
        if(num==0) return false;
        return (num&(num-1))==0;
    }
}
