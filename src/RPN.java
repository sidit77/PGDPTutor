import java.util.Stack;

public class RPN {

    public static void eval(String[] input, Stack<Integer> stack){

        for(String s : input){
            switch(s){
                case "+": stack.push(stack.pop() + stack.pop());
                    break;
                case "*": stack.push(stack.pop() * stack.pop());
                    break;
                case "^2": stack.push(stack.peek() * stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
    }

    public static void main(String[] args){
        Stack<Integer> is = new Stack<Integer>();
        eval("12 4 +".split(" "), is);
        System.out.print(is.pop() == 16 ? "": "Error 1\n");

        eval("4 3 5 * +".split(" "), is);
        System.out.println(is.pop() == 19 ? "": "Error 2\n");

        eval("12 4 + ^2".split(" "), is);
        System.out.println(is.pop() == 16 * 16 ? "": "Error 3\n");
    }

}
