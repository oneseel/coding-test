import java.util.*;

// 마을과 이동 시간을 저장하는 노드 클래스
class Node {
    int town;
    int time;

    Node(int town, int time) {
        this.town = town;
        this.time = time;
    }
}
class Solution {
    static List<List<Node>> graph;
    static int[] visit;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        visit = new int[N + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int town1 = r[0];
            int town2 = r[1];
            int time = r[2];
            graph.get(town1).add(new Node(town2, time));
            graph.get(town2).add(new Node(town1, time));
        }
        
        return bfs(1, K, N);
    }
    
    public int bfs(int start, int K, int N) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visit[start] = 0;
        
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            
            for (Node next : graph.get(temp.town)) {
                if (visit[next.town] > visit[temp.town] + next.time) {
                    visit[next.town] = visit[temp.town] + next.time;
                    if (visit[next.town] <= K) {
                        queue.add(new Node(next.town, visit[next.town]));
                    }
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i] <= K) {
                count++;
            }
        }
        
        return count;
    }

}
