package Algorithms;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yuhua on 7/30/15.
 */
public class ParseFormula {

    public static void main(String[] args) {
        String str = "5+(2x–3y)=3+3y";
        //String str = "5+2x–(3y+2x-(7–2x)–9)=3+4y";
        double x = 2.0;
        System.out.println(evaluate(str,x));
    }



    public static double evaluate(String f, double x_val) {
        double sum_y_left = 0, sum_y_right = 0;
        double sum_num_left = 0, sum_num_right = 0;
        boolean onLeft=true;
        int last_op = 1, bracket_op = 1;
        Stack<Integer> brackets = new Stack<Integer>();

        for(int i = 0; i < f.length(); ++i) {
            char c = f.charAt(i);
            if(c >= '0' && c <= '9') {
                int over = i + 1;
                while(f.charAt(over) >= '0' && f.charAt(over) <= '9') ++over;
                double number = Double.parseDouble(f.substring(i, over)) * last_op * bracket_op;

                if(f.charAt(over) == 'x') {
                    if(onLeft)
                        sum_num_left += number * x_val;
                    else
                        sum_num_right += number * x_val;
                    i = over;
                } else if(f.charAt(over) == 'y') {
                    if(onLeft)
                        sum_y_left += number;
                    else
                        sum_y_right += number;
                    i = over;
                } else {
                    if(onLeft)
                        sum_num_left += number;
                    else
                        sum_num_right += number;
                    i = over - 1;
                }
            } else if( c == 'x' ) {
                if(onLeft)
                    sum_num_left += last_op * bracket_op * x_val;
                else
                    sum_num_right += last_op * bracket_op * x_val;
            } else if( c == 'y' ){
                if(onLeft)
                    sum_y_left += last_op * bracket_op;
                else
                    sum_y_right += last_op * bracket_op;
            } else if( c == '(' ) {
                brackets.push(last_op);
                bracket_op *= last_op;
                last_op = 1;
            } else if( c == ')' ) {
                bracket_op /= brackets.peek();
                brackets.pop();
            } else if( c == '+' || c == '–' ) {
                last_op = c == '+' ? 1 : -1;
            } else if( c == '=' || c == '\0' ) {
                onLeft=false;
                last_op = 1;
                brackets = new Stack<Integer>();
            }
        }
        return (sum_num_right - sum_num_left) / (sum_y_left - sum_y_right);
    }
}
