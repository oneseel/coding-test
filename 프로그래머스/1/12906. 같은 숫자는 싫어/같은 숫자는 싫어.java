import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int number : arr) {
            if (!stack.isEmpty()) {
                if (stack.peek() != number) {
                    stack.push(number);
                }
            } else {
                stack.push(number);
            }
        }
        
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}