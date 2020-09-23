import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='(')
                stack.pop();
            else if(s.charAt(i)==')')
                stack.add(s.charAt(i));
            else if(s.charAt(i)=='[' && !stack.isEmpty() && stack.peek()==']')
                stack.pop();
            else if(s.charAt(i)=='[')
                stack.add(s.charAt(i));
            else if(s.charAt(i)=='{' && !stack.isEmpty() && stack.peek()=='}')
                stack.pop();
            else if(s.charAt(i)=='{')
                stack.add(s.charAt(i));
            else
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {

    }
}
