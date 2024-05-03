import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int day = Integer.parseInt(br.readLine());
            int[] stock = new int[day];
            long benefit = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < day; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }
            
            int max = 0;
            
            for (int j = day - 1; j >= 0; j--) {
                if (stock[j] > max) {
                    max = stock[j];
                } else {
                    benefit += max - stock[j];
                }
            }
            
            System.out.println(benefit);
        }
    }
}
