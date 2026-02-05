import java.util.NoSuchElementException;

public class ReversePolishNotation {
    static String symbols = "()+-*/";
    /**
     Takes in a postfix expression as a String, evaluates it, and returns the answer
     @param input A postfix string where the numbers and operators are space separated
     @return Integer Answer
     @throws IllegalArgumentException if given an invalid postfix expression
     */
    static int evaluatePostfix(String input) throws IllegalArgumentException{
        String[] str = input.split(" ");
        Stack s = new Stack();
        for (String c:str){
            if(symbols.contains(c)){
                if (s.size()<2){
                    throw new IllegalArgumentException();
                }
                int i2 = Integer.parseInt(s.pop());
                int i1 = Integer.parseInt(s.pop());
                s.push(evaluate(c,i1,i2));
            }
            else{
                s.push(c);
            }
        }
        return Integer.parseInt(s.peek());
    }

    /**
     Takes in an infix expression as a String, converts it to a postfix expression and returns it
     @param input An infix string where the numbers and operators are space separated
     @return postfix string
     */
    static String infixToPostfix(String input){
        String[] str = input.split(" ");
        Stack s = new Stack();
        String out = "";
        for (String c:str){
            if(symbols.contains(c)){
                if (s.isEmpty()){
                    s.push(c);
                }
                else if (c.equals("(")){
                    s.push(c);
                }
                else if(c.equals(")")){
                    while (!s.isEmpty()&&!s.peek().equals("(")){
                        out+=s.pop()+" ";
                    }
                    s.pop();
                }
                else if ((symbols.indexOf(c)/2)<=(symbols.indexOf(s.peek())/2)){
                    while(!s.isEmpty()&&(symbols.indexOf(c)/2)<=(symbols.indexOf(s.peek())/2)&&(!s.peek().equals("("))){
                        out+=s.pop()+" ";
                    }
                    s.push(c);
                }
                else{
                    s.push(c);
                }
            }
            else{
                out+=c+" ";
            }
        }
        while (!s.isEmpty()){
            out+=s.pop()+" ";
        }
        out=out.replaceAll("  "," ").substring(0,out.length()-2);
        return out;
    }

    /**
     * Helper method to evaluate simple operations
     * @param symbol operation to be completed (+,-,*,/)
     * @param i1 first integer
     * @param i2 second integer
     * @return solution
     */
    static String evaluate(String symbol, int i1, int i2){
        if (symbol.equals("+")){
            return Integer.toString(i1+i2);
        }
        else if (symbol.equals("-")){
            return Integer.toString(i1-i2);
        }
        else if (symbol.equals("*")){
            return Integer.toString(i1*i2);
        }
        else{
            return Integer.toString(i1/i2);
        }
    }

    /**
     Takes in a prefix expression as a String, evaluates it, and returns the answer
     @param input A prefix string where the numbers and operators are space separated
     @return Integer Answer
     @throws IllegalArgumentException if given an invalid prefix expression
     */
    static int evaluatePrefix(String input) throws IllegalArgumentException{
        String[] str = input.split(" ");
        Stack s = new Stack();
        for (int i=(str.length-1);i>=0;i--){
            String c=str[i];
            if(symbols.contains(c)){
                if (s.size()<2){
                    throw new IllegalArgumentException();
                }
                int i1 = Integer.parseInt(s.pop());
                int i2 = Integer.parseInt(s.pop());
                s.push(evaluate(c,i1,i2));
            }
            else{
                s.push(c);
            }
        }
        return Integer.parseInt(s.peek());
    }
}
