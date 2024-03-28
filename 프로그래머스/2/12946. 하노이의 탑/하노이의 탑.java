import java.util.*;

class Solution {
    private static List<int[]> list;
    
    public int[][] solution(int n) {
        list = new ArrayList<>();
        
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][2];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    private static void hanoi(int n, int start, int mid, int end) {
        
        if (n == 1) {
            System.out.println(start + " => " + end);
            list.add(new int[] {start, end});
            return;
        }
        // 1 => 2 (가장 큰 원반 위의 원반들을 임시 기둥으로 옮기는 과정)
        hanoi (n - 1, start, end, mid);
        
        // 1 => 3 (가장 큰 원반이 목표기둥으로 옮기는 과정)
        System.out.println(start + " => " + end);
        list.add(new int[] {start, end});
        
        // 2 => 3 (임시기둥에 있는 원반들을 목표기둥으로 옮기는 과정)
        hanoi (n - 1, mid, start, end);
    }
}