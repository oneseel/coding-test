import java.util.*;

class Solution {
    public int solution(String s) {
        int idx = 0; // 회전 수
        int count = 0;
        String temp = s;

        // 문자열 회전하기
        while (idx < s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i< s.length(); i++) {
                sb.append(temp.charAt(i));
            }
            sb.append(temp.charAt(0));
            temp = sb.toString();
            if (check(temp)) {
                count++;
            }
            idx++;
        }

        return count;
    }

    private boolean check(String str) {
        // 올바른 괄호인지 확인하기
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (stack.isEmpty() || c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if (c == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if (c == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }
}