 /** Compute the value of an expression in Reverse Polish order. Supported operators are "+", "-", "*" and "/".
             * Reverse Polish is a postfix mathematical notation in which each operator immediately follows its operands.
             * Each operand may be a number or another expression.
             * For example, 3 + 4 in Reverse Polish is 3 4 + and 2 * (4 + 1) would be written as 4 1 + 2 * or 2 4 1 + *
             *
             * @param ops a sequence of numbers and operators, in Reverse Polish order
             * @return the result of the computation
             * @throws IllegalArgumentException ops don't represent a well-formed RPN expression
             * @throws ArithmeticException the computation generates an arithmetic error, such as dividing by zero
             *
             * <p>Some sample ops and their results:
             * ["4", "1", "+", "2.5", "*"] -> ((4 + 1) * 2.5) -> 12.5
             * ["5", "80", "40", "/", "+"] -> (5 + (80 / 40)) ->  7
             */
/*
public float computeReversePolishOrder(String[] strs) {
    if(str==null || str.length()<1){
        return 0.0;
    }
    
    Stack<Float> stk = new LinkedList<Float>();
    
    try{
      for(int i=0; i<str.length(); i++){
        if(String.equals(str[i],"+") || String.equals(str[i],"-") || String.equals(str[i],"-") || String.equals(str[i],"/") ){
            if(stk.isEmpty()){
                //throw exception
                throw new Error ("invalid expression");
            }
            float v2 = stk.pop();
            if(stk.isEmpty()){
                //throw exception
                 throw new Error ("invalid expression");
            }
            float v1 = stk.pop();
            float rel = 0.0
            if(String.equals(str[i],"+")){
                rel = v1+ v2;
            }
            else if(String.equals(str[i],"-")){
                rel = v1 - v2;
            }
            else if(String.equals(str[i],"*")){
                rel = v1 * v2;
            }
            else{
                rel = v1 / v2;
            }
            if(i==str.length()-1){
                if(stk.isEmpty()){
                    return rel;
                }
                //throw exception: invalid expression
                 throw new Error ("invalid expression");    
            }
            else{
                stk.push(rel);
        }
        else{
            stk.push(String.toFloat(str[i]));
        }
      }
      if(!stk.isEmpty()){
          //invalid expression
          throw new Error ("invalid expression");
      }
    }
    catch(//arithmetic expception){
     //exception handle
    }
    catch(Exception ex){
     System.out.println("invalid expression");
    } 
                
}
*/