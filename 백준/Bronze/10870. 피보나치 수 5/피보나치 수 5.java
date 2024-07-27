import java.io.*;

class Main {
    private static int[] dp = new int[21];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        
        if (n == 0) {
        	System.out.print(0);
        	return;
        }
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        System.out.println(dp[n]);
    }
}