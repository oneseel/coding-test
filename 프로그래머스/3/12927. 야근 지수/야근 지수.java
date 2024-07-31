import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        for (int i = 0; i < n; i++) {
            int temp = pq.poll();
            if (temp <= 0) break;
            pq.offer(temp - 1);
        }
        
        return result(pq);
    }
        
    private long result(PriorityQueue<Integer> works) {
        long sum = 0;
        while (!works.isEmpty()) {
            sum += Math.pow(works.poll(), 2);
        }
        return sum;
    }
    
}