import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int idx = i;
            while (!queue.isEmpty() && idx < prices.length) {
                if (queue.peek() <= prices[idx]) {
                    answer[i - 1] += 1;
                    idx++;
                } else {
                    answer[i - 1] += 1;
                    break;
                }
            }
            queue.poll();
            queue.offer(prices[i]);
        }

        answer[answer.length - 1] = 0;

        return answer;
    }
}