package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhua on 1/3/16.
 */
public class BulbSwitcher {
    public static void main(String[] args) {
        BulbSwitcher inst = new BulbSwitcher();
        System.out.println(inst.bulbSwitch(999999));
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
