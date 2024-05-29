import java.util.*;

class Solution {
    private static List<List<Integer>> tree;
    private static boolean[] visited;
    private static int v1, v2, count;
    
    public int solution(int n, int[][] wires) {
        
        // 트리 구성
        tree = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            v1 = wire[0];
            v2 = wire[1];
            // 각 노드 연결
            tree.get(v1).add(v2);
            tree.get(v2).add(v1); 
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            v1 = wire[0];
            v2 = wire[1];
            // 각 노드 끊기
            tree.get(v1).remove(Integer.valueOf(v2));
            tree.get(v2).remove(Integer.valueOf(v1));
            
            visited = new boolean[n + 1];
            count = bfs(v1);
            
             min = Math.min(min, Math.abs((n - count) - count));
            
            // 재연결
            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }
        
        return min;
    }
    
    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        count = 1;
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int i : tree.get(temp)) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}