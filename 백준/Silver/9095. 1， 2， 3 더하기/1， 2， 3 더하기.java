import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n < 4) {
                if (n == 0) System.out.println(0);
                else if (n == 1) System.out.println(1);
                else if (n == 2) System.out.println(2);
                else if (n == 3) System.out.println(4);
                continue;
            }
            
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[n]);
        } 
    } 
}
