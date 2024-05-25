import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (String op : operations) {
            String[] temp = op.split(" ");
            String command = temp[0];
            int number = Integer.parseInt(temp[1]);
            
            switch (command) {
                case "I" :
                    minPq.offer(number);
                    maxPq.offer(number);
                    break;
                case "D" :
                    // 최댓값 삭제
                    if (number == 1) {
                        minPq.remove(maxPq.poll());
                    // 최솟값 삭제
                    } else if (number == -1) {
                        maxPq.remove(minPq.poll());
                    }
                    break;     
            }
        }
        
        if (minPq.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {maxPq.peek(), minPq.peek()};
        }
    }
}