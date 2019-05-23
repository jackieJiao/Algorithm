package stack;
import java.util.Stack;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{[()]}"));
    }


    private Boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            //left brackets pushed to stack;
            if (c=='(' || c=='{'||c=='[')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                if (c=='}' && stack.pop()!='{')
                    return false;
                if (c==']' && stack.pop()!='[')
                    return false;
                if (c==')' && stack.pop()!='(')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
