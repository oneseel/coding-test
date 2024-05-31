import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int max = 0;

    int[] dp = new int[y + 1];
    dp[0] = h;

    for (int i = 1; i <= y; i++) {
      if (i < 3) {
        dp[i] = (int) (dp[i - 1] * 1.05);
      } else if (i < 5) {
        dp[i] = Math.max((int) (dp[i - 1] * 1.05), (int) (dp[i - 3] * 1.20));
      } else {
        dp[i] = Math.max((int) (dp[i - 1] * 1.05), Math.max((int) (dp[i - 3] * 1.20), (int) (dp[i - 5] * 1.35)));
      }
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
