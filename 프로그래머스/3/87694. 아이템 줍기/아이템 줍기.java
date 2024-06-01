import java.util.*;

class Solution {
    private static int[][] maps = new int[101][101];
    private static boolean[][] visited = new boolean[101][101];
    private static int result =0;
    
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        makeMaps(rectangle);
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return result;
    }

    static void makeMaps(int[][] rectangle) {
        for(int[] square : rectangle) {
            int x1 = square[1] * 2;
            int x2 = square[3] * 2;

            int y1 = square[0] * 2;
            int y2 = square[2] * 2;

            for (int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    if(i == x1 || i == x2 || j == y1 || j == y2) {
                        if(maps[i][j] == 2) {
                            continue;
                        }
                        maps[i][j] = 1;
                    }
                    else {
                        maps[i][j] = 2;
                    }
                }
            }
        }
    }
    
    private static void bfs(int characterX, int characterY, int itemX, int itemY) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterY, characterX, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (x == itemY && y == itemX) {
                result = count/2;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (1 <= nx && nx <= 100 && 1 <= ny && ny <=100) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny, count + 1});
                    }
                }
            }
        }
    }
}