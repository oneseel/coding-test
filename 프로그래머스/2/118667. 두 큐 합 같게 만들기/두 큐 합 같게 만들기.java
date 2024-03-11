import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0; 
        long sum2 = 0;
        
        for (int num : queue1) {
            sum1 += num;
        }
        for (int num : queue2) {
            sum2 += num;
        }
        
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        
        int count = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        for (int que : queue1) {
            que1.offer(que);
        }
        for (int que : queue2) {
            que2.offer(que);
        }
        
        while (sum1 != sum2) {
            if (count > (que1.size() + que2.size()) * 2) {
                return -1;
            }
            
            if (sum1 < sum2) {
                int temp = que2.poll();
                que1.offer(temp);
                sum1 += temp;
                sum2 -= temp;
            } else {
                int temp = que1.poll();
                que2.offer(temp);
                sum2 += temp;
                sum1 -= temp;
            }
            count++;
        }
        
        return count;
    }
}
