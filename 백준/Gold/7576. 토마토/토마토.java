import java.io.*;
import java.util.*;

class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m;
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[] {i, j, 0}); // 초기에 익은 토마토들을 큐에 추가
                    visited[i][j] = true;
                }
            }
        }

        int day = bfs();
        
        if (check()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int day = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            day = temp[2]; // 현재까지 걸린 일수

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n && map[nx][ny] == 0 && !visited[nx][ny]) {
                    map[nx][ny] = 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, day + 1});
                }
            }
        }
        return day;
    }

    private static boolean check() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
