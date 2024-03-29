import java.util.*;

class Solution {
    private static boolean[][] visited;
    private static char[][] point;
    
    public int solution(String[] maps) {
        point = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
         for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                point[i][j] = maps[i].charAt(j);
            }
        }
        
        int slCount = move('S', 'L'); // 시작지점에서 레버까지 이동할 때 시간
        if (slCount == -1) return -1;

        int leCount = move('L', 'E'); // 레버에서 도착지점까지 이동할 때 시간
        if (leCount == -1) return -1;

        return slCount + leCount;
    }
    
    private static int move(char start, char end) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        
         for (int i = 0; i < point.length; i++) {
            for (int j = 0; j < point[0].length; j++) {
                if (point[i][j] == start) {
                    queue.offer(new int[]{i, j, 0});
                    visited = new boolean[point.length][point[0].length];
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (point[x][y] == end) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < point.length && ny >= 0 && ny < point[0].length && !visited[nx][ny] && point[nx][ny] != 'X') {
                    queue.offer(new int[]{nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}