import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, k;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][m + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (i == n && j == m && k == n * m) {
                    System.out.println(0);
                    return;
                }
                if (i == n && j == m && k != n * m) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i == n || j == m) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i * j == k) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
