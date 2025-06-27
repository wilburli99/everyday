package day2;

import java.util.Stack;

public class match_bracket {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            // 如果是左括号，则入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // 如果是右括号，则判断栈顶的左括号是否匹配
            if (c == ')' || c == ']' || c == '}'){
                if (stack.isEmpty()) {
                    return false;
                }
                // 栈顶的左括号匹配
                char top = stack.pop();
                if (c == ')' && top != '(' ||
                        c == ']' && top != '[' ||
                        c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
