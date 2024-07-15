import java.util.Stack;

class Solution {
    public int solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(rotate(s))) {
                count++;
            }
            s = rotate(s);
        }
        return count;
    }

    // 문자열을 회전하는 메서드
    private String rotate(String s) {
        return s.substring(1) + s.charAt(0);
    }

    // 올바른 괄호인지 확인하는 메서드
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
