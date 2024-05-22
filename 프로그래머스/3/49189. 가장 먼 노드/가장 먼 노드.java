import java.util.*;

class Solution {
    private static List<List<Integer>> graph;
    private static int[] distances;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        } 
        
        for (int[] i : edge) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        
        distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;
        
        bfs(1);
        
        int max = 0; // 1과 가장 멀리 있는 노드의 길이
        int count = 0; // 1과 가장 멀리 있는 노드의 수
        
        for (int i : distances) {
            if (i > max) {
                max = i;
                count = 1;
            } else if (i == max) {
                count++;
            }
        }
        
        return count;        
    }
    
    private static void bfs (int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int i : graph.get(temp)) {
                if (distances[i] == -1) {
                    distances[i] = distances[temp] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}