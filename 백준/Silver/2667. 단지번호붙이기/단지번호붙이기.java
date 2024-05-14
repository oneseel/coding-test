import java.io.*;
import java.util.*;

class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> count;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        count = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 집이면서 방문하지 않은 곳을 시작점으로
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(count.size());
        Collections.sort(count);
        for (int i : count) {
            System.out.println(i);
        }
    }

    private static void bfs (int sx, int sy) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy});
        visited[sx][sy] = true;
        int houseCount = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    houseCount++;
                }
            }
        }
        count.add(houseCount);
    }
}