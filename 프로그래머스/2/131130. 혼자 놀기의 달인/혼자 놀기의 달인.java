import java.util.*;

public class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> group = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int currentBox = i;
                int count = 0;
                
                while (!visited[currentBox]) {
                    visited[currentBox] = true;
                    currentBox = cards[currentBox] - 1;
                    count++;
                }
                
                group.add(count);
            }
        }
        
        group.sort((o1, o2) -> o2 - o1);
        
        if (group.size() < 2) {
            return 0;
        } else {
            return group.get(0) * group.get(1);
        }
    }
}
