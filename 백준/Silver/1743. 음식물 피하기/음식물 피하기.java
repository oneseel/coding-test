import java.io.*;
import java.util.*;

class Main {
    private static int[][] maps; // 위치 정보
    private static boolean[][] visited; // 방문여부
    private static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 열
        m = Integer.parseInt(st.nextToken()); // 행
        int k = Integer.parseInt(st.nextToken()); // 쓰레기의 수
        
        maps = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            maps[x][y] = 1; 
        }
        
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               if (maps[i][j] == 1 && !visited[i][j]) {
                   maxCount = Math.max(maxCount, bfs(i, j));
               }
           } 
        }
        
        System.out.println(maxCount);
    }
    
    private static int bfs(int sx, int sy) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        int c = 0;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            c++;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m && 
                    maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return c;
    }
}
