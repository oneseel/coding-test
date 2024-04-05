import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        long sum = 0;
        
        for (int i = 1; i <= n; i++) {
            sum += (n / i) * i;
        }
        
        System.out.println(sum);
    }
}
