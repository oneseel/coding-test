import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int s = 1, e = 1, sum = 1, count = 0;

        while (e <= n) {
            if (sum < n) sum += ++e;
            else if (sum > n) sum -= s++;
            else {
                count++;
                sum -= s++;
            }
        }

        System.out.println(count);
    }
}
