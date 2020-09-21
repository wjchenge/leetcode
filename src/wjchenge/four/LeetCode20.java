package wjchenge.four;

import java.util.Stack;

/**
 * 20. 有效的括号
 * @author wjchenge
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        if (s == null) return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c ) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
