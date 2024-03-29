import java.util.*;

class Solution {
    private static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int count = bfs(maps, 0, 0);
        return count;
    }
    
    private static int bfs(int[][] maps, int sx, int sy) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length];
        
        queue.offer(new int[] {sx, sy, 1});
        visited[sx][sy] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            
            if (x == maps.length - 1 && y == maps[0].length - 1) {
                return count;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && !visited[nx][ny] && maps[nx][ny] != 0) {
                    queue.offer(new int[] {nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            } 
        }
           
        return -1;
    }
}