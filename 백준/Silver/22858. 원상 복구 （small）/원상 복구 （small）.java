import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) + 1;
        int[][] SK = new int[K][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SK[K - 1][i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = K - 1; i >= 1; i--) {
            for (int j = 0; j < N; j++) {
                SK[i - 1][D[j] - 1] = SK[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(SK[0][i] + " ");
        }
    }
}