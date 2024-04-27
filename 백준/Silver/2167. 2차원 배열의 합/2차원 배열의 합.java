import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M]; // 기존 배열
        int[][] prefixSum = new int[N][M]; // 누적합 배열
        
        // 기존 배열 입력 및 누적합 배열 계산(행)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (j == 0) prefixSum[i][j] = arr[i][j];
                else prefixSum[i][j] = prefixSum[i][j - 1] + arr[i][j];
            }
        }
        
        // 누적합 배열 계산(열)
         for (int j = 0; j < M; j++) {
            for (int i = 1; i < N; i++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }
        
        // 구간합 구하기
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            
            int sum = prefixSum[x2][y2];
            if (x1 > 0) sum -= prefixSum[x1 -1][y2];
            if (y1 > 0) sum -= prefixSum[x2][y1 - 1];
            if (x1 > 0 && y1 > 0) sum += prefixSum[x1 - 1][y1 - 1];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}