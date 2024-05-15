import java.io.*;
import java.util.*;

class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m, count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];
            count = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs (int sx, int sy) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        count++;
    }
}