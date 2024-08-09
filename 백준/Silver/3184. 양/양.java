import java.io.*;
import java.util.*;

class Main {
    private static int R, C;
    private static String[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열

        arr = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int totalWolf = 0; // 전체 늑대의 수
        int totalSheep = 0; // 전체 양의 수

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 아직 방문하지 않은
                if (!visited[i][j]) {
                    // 늑대 혹은 양일 때, bfs를 실행
                    if (arr[i][j].equals("v") || arr[i][j].equals("o")) {
                        int[] bfsArr = bfs(i, j, 0, 0);
                        int sheep = bfsArr[0];
                        int wolf = bfsArr[1];
                        
                        // 늑대가 양보다 많거나 같을 때는 늑대만 더해주고,
                        if (wolf >= sheep) {
                            totalWolf += wolf;
                        // 적을 때는 양만 더해준다.
                        } else {
                            totalSheep += sheep;
                        }
                    }
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    private static int[] bfs(int sx, int sy, int sheep, int wolf) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy});
        visited[sx][sy] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (arr[x][y].equals("v")) wolf++;
            if (arr[x][y].equals("o")) sheep++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
    
                // '#'일 경우를 제외한 값을 큐에 넣어준다.
                if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && !arr[nx][ny].equals("#")) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return new int[] {sheep, wolf};
    }
}