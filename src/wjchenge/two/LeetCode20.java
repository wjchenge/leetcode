package wjchenge.two;

import java.util.Stack;

/**
 * 20. 有效的括号
 * @author wjchenge
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        if (s == null) return true;
        int length = s.length();
        if (length % 2 != 0) return false;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < length; i++) {
            if ('(' == s.charAt(i)) {
                stack.push(')');
            } else if ('[' == s.charAt(i)) {
                stack.push(']');
            } else if ('{' == s.charAt(i)) {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
