import java.util.*;

class Solution {
    private boolean[][] visited;
    private int n, m;
    private int[] oil;
        
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oil = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }

        return Arrays.stream(oil).max().getAsInt();   
    }
    
    private void bfs (int sx, int sy, int[][] land) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy});
        visited[sx][sy] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            set.add(y);
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (check(nx, ny, land)) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        
        for (int i : set) {
            oil[i] += count;
        }
    }
    
    private boolean check (int nx, int ny, int[][] land) {
        return (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && land[nx][ny] == 1);
    }
}