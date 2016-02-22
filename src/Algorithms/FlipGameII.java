package Algorithms;

/**
 * Created by yuhuazh on 12/24/2015.
 */
public class FlipGameII {

    public static void main(String[] args) {
        String s = "++++-++++++";
        //String s = "++++++";
        FlipGameII inst = new FlipGameII();
        System.out.println(inst.canWin(s));
    }

    public boolean canWin(String s) {
        for (int i = 0; i < s.length() - 1; ++i)
            //such 2-player game is suitable for recursion: one's win is the other's loss
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' && !canWin(s.substring(0, i) + "--" + s.substring(i + 2)))
                return true;
        return false;
    }
}
