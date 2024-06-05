import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 정렬(나가는 시점을 기준으로)
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int count = 1;
        int current = routes[0][1];
        
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > current) {
                current = routes[i][1];
                count++;
            } 
        }
        
        return count;
    }
}