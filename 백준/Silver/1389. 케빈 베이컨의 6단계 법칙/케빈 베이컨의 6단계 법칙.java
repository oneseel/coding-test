import java.io.*;
import java.util.*;

class Main {
    private final static int INF = 9999999; // 무한대를 표현

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        
        // 배열 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        // 친구관계 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) { // 경유지
            for (int i = 1; i <= N; i++) { // 출발지
                for (int j = 1; j <= N; j++) { // 도착지
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int[] result = new int[2];
        result[0] = INF;

        // 케빈 베이컨의 수를 구함
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += arr[i][j];
            }
    
            if (result[0] > sum) {
                result[0] = sum;
                result[1] = i;
            }
        }

        System.out.println(result[1]);
    }
}
