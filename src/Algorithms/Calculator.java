import java.util.Stack;

/**
 * Created by yuhuazh on 8/19/2016.
 */
public class Calculator {
    public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        Stack<String> stk = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);

            if(c=='+'){
                stk.push("+");
            }
            else if(c=='-'){
                stk.push("-");
            }
            else if(c=='('){
                stk.push("(");
            }
            else if(c==')'){
                int num2=Integer.valueOf(stk.pop());
                stk.pop(); //pop the left parenthese
                while(!stk.isEmpty()&&!stk.peek().equals("(")){
                    //compute within the outter level parenthese
                    String o = stk.pop();
                    int num1 = Integer.valueOf(stk.pop());
                    if(o.equals("+")) num2=num1+num2;
                    if(o.equals("-")) num2=num1-num2;
                }
                stk.push(String.valueOf(num2));
            }
            else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){//get a number
                int num2=c-'0';
                i++;
                while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    num2=num2*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;

                while(!stk.isEmpty()&&!stk.peek().equals("(")){
                    //compute within the outter level parenthese
                    String o = stk.pop();
                    int num1 = Integer.valueOf(stk.pop());
                    if(o.equals("+")) num2=num1+num2;
                    if(o.equals("-")) num2=num1-num2;
                }
                stk.push(String.valueOf(num2));
            }
            i++;
        }
        return Integer.valueOf(stk.pop());
    }

    public static void main(String[] args) {
        Calculator inst = new Calculator();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(inst.calculate(s));
    }
}
