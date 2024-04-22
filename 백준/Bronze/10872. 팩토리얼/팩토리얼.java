import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n));
    }
    
    private static int factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}