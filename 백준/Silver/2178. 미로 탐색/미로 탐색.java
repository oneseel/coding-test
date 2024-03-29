import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] maps;
    private static boolean[][] visited;
    private static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        maps = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                maps[i][j] = s.charAt(j) - '0';
            }
        }
        
        int[] start = {0, 0};
        
        System.out.println(bfs(start));
    }
    
    private static int bfs(int[] start) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 1});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            
            if (x == n - 1 && y == m - 1) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny, count + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}
