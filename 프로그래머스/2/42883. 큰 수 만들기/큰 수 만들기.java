import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            
            // 스택에 있는 값과 들어올 값을 비교
            while (k > 0 && !stack.isEmpty() && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // k가 0보다 큰 경우, 스택에서 더 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }  
}