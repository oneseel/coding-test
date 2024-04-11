import java.util.*;

class Solution {
    public int solution(String name) {
        int upDown = 0; // 상하 이동
        int leftRight = name.length() - 1; // 좌우 이동(오른쪽으로만 이동할 경우)
        int distance = 0; // 연속된 A
        
        for(int i = 0; i < name.length(); i++) {
            // 상하 이동
            upDown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            distance = i + 1;
            
            // 연속된 A의 개수 구하기
            while(distance < name.length() && name.charAt(distance) == 'A') {
                distance++;
            }
            
            leftRight = Math.min(leftRight, i * 2 + name.length() - distance);
            leftRight = Math.min(leftRight, (name.length() - distance) * 2 + i);
        }
        
        return upDown + leftRight;
    }
}