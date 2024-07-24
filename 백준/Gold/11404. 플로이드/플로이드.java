import java.io.*;
import java.util.*;

class Main {
    private final static int INF = 9999999;

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine());  // 버스의 개수

        // 비용을 저장할 배열
        int[][] cost = new int[n + 1][n + 1];

        // 비용 배열 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(cost[i], INF);
            cost[i][i] = 0;
        }

        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (cost[a][b] > c) {
                cost[a][b] = c;
            }
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cost[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(cost[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
