import java.io.*;
import java.util.*;

class Main {
    private final static int INF = 9999999; // 무한대를 표현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 마을의 수 (정점의 수)
        int E = Integer.parseInt(st.nextToken()); // 도로의 수 (간선의 수)

        // 거리 배열 초기화
        int[][] dist = new int[V + 1][V + 1];

        // 거리 배열을 무한대로 초기화
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
        }

        // 간선 정보를 입력받아 거리 배열 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= V; k++) { // 경유점
            for (int i = 1; i <= V; i++) { // 출발점
                for (int j = 1; j <= V; j++) { // 도착점
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 최소 사이클 거리 찾기
        int minCycle = INF;
        for (int i = 1; i <= V; i++) {
            if (dist[i][i] < minCycle) {
                minCycle = dist[i][i];
            }
        }

        // 출력
        if (minCycle == INF) {
            System.out.println("-1"); // 사이클이 없는 경우
        } else {
            System.out.println(minCycle);
        }
    }
}
