import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuhuazh on 7/8/2016.
 */
public class RPN {
    public abstract class Operate{
            protected List<Integer> operands;
            public Operate(){
                operands= new ArrayList<>();
            }
            public abstract boolean getOperands(Stack<Integer> stk);
            public abstract int excute();

            public boolean getBinaryOperands(Stack<Integer> stk){
                operands.clear();
                int i=0;
                while(!stk.isEmpty()&&i<2){
                    operands.add(stk.pop());
                    i++;
                }
                return operands.size()==2;
            }
        }

        public class OperatorAdd extends Operate{
            @Override
            public boolean getOperands(Stack<Integer> stk){
                return getBinaryOperands(stk);
            }
            @Override
            public int excute(){
                return operands.get(0)+operands.get(1);
            }
        }

        public class OperatorMinus extends Operate{
            @Override
            public boolean getOperands(Stack<Integer> stk){
                return getBinaryOperands(stk);
            }
            @Override
            public int excute(){
                return operands.get(1)-operands.get(0);
            }
        }

        public class OperatorMultiply extends Operate{
            @Override
            public boolean getOperands(Stack<Integer> stk){
                return getBinaryOperands(stk);
            }
            @Override
            public int excute(){
                return operands.get(1)*operands.get(0);
            }
        }

        public class OperatorDivide extends Operate{
            @Override
            public boolean getOperands(Stack<Integer> stk){
                return getBinaryOperands(stk);
            }
            @Override
            public int excute(){
                return operands.get(1)/operands.get(0);
            }
        }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        OperatorAdd oAdd = new OperatorAdd();
        OperatorMinus oMinus = new OperatorMinus();
        OperatorMultiply oMlp = new OperatorMultiply();
        OperatorDivide oDivide = new OperatorDivide();

        for(String t : tokens){
            if(t.equals("+")){
                if(oAdd.getOperands(stk))
                    stk.push(oAdd.excute());
                continue;
            }
            if(t.equals("-")){
                if(oMinus.getOperands(stk))
                    stk.push(oMinus.excute());
                continue;
            }
            if(t.equals("*")){
                if(oMlp.getOperands(stk))
                    stk.push(oMlp.excute());
                continue;
            }
            if(t.equals("/")){
                if(oDivide.getOperands(stk))
                    stk.push(oDivide.excute());
                continue;
            }
            stk.push(Integer.valueOf(t));
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        RPN inst = new RPN();
        String[] tokens = {"4","-2","/","2","-3","-","-"};
        System.out.println(inst.evalRPN(tokens));
    }
}
