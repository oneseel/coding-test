import java.util.*;

class Solution {
    private List<List<Integer>> list;
    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        list = new ArrayList<>();
        visited = new boolean[n];
        int count = 0; // 네트워크의 수

        // 인접리스트 생성
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 자기자신을 제외한 다른 컴퓨터와 연결
                if (computers[i][j] == 1 && i != j) {
                    list.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        return count;
    }

    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i: list.get(current)) {
                if (!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}