import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int sum = 0;
        int index = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = -1;
        int minEnd = -1;

        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            deque.addLast(sequence[i]);

            while(sum > k){
                sum -= deque.getFirst();
                deque.removeFirst();
                index++;
            }

            if (sum == k && minLength > deque.size()) {
                minLength = deque.size();
                minStart = index;
                minEnd = i;
            }
        }

        return new int[] {minStart, minEnd};
    }
}