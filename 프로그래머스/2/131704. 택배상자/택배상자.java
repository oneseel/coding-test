import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        //보조 컨테이너
        Stack<Integer> sub = new Stack<>();
        // 원하는 번호
        int target = 0;
        
        for (int i = 1; i <= order.length; i++) {
            if (order[target] != i) {
                sub.add(i);
                continue;
            }
            target++;
            answer++;
            
            while (sub.size() != 0 && order[target] == sub.peek()) {
                sub.pop();
                target++;
                answer++;
            }
        }
        
        return answer;
    }
}