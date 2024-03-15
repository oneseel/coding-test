import java.util.*;

class Solution {
    static boolean[] visit;
    static List<List<Integer>> tree;
    
    public int solution(int n, int[][] wires) {
        
        // 트리 만들기
        tree = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];

            // 노드 연결 제거
            tree.get(node1).remove(Integer.valueOf(node2));
            tree.get(node2).remove(Integer.valueOf(node1));
            
            visit = new boolean[n + 1];
            int count = bfs(node1);
            
            min = Math.min(min, Math.abs((n - count) - count));
            
            // 노드 다시 연결
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        
        return min;
    }
    
    public int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visit[node] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i : tree.get(temp)) {
                if (!visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}