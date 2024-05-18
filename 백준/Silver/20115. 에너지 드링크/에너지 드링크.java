import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n];
        int max = 0;
        double sum = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
            if (drink[i] > max) max = drink[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (drink[i] == max) {
                sum += (double) max;
            } else {
                sum += (double) drink[i] / 2;
            }
        }
        
        System.out.println(sum);
    }
}