import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 계단 수
        int[] score = new int[n + 1]; // 각 계단의 점수

        for (int i = 1; i < n + 1; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(score[1]);
            return;
        } else if (n == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        for (int i = 4; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        System.out.println(dp[n]);
    }
}
