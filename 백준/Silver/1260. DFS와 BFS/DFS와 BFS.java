import java.io.*;
import java.util.*;

class Main {
    private static int[][] arr; // 간선을 저장할 배열
    private static boolean[] visited; // 방문 표시 배열
    private static int n, m, v;
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 노드
        m = Integer.parseInt(st.nextToken()); // 간선
        v = Integer.parseInt(st.nextToken()); // 시작점
        
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        
        dfs(v);
        Arrays.fill(visited, false); // 방문배열 초기화
        System.out.println();
        bfs(v);
    }
    
    // dfs
    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        
        for (int i = 1; i <= n; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    // bfs
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int i = 1; i <= n; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
