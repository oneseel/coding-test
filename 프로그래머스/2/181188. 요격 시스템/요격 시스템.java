import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int prev = 0;
        int count = 0;
        
        // e를 기준으로 정렬(같으면 s를 기준으로 정렬)
        Arrays.sort(targets, (o1, o2) -> 
            (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1]
        );

        for (int i = 0; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];
            if (prev <= s) {
                prev = e;
                count++;
            }
        }
        
        return count;
    }
}