import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 횟수
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int answer = lastNumber(a, b);
            System.out.println(answer);
        }
    }
    private static int lastNumber(int a, int b) {
        a = a % 10;
        if (a == 0) return 10;
        
        int[] numbers = {a, (a * a) % 10, (a * a * a) % 10, (a * a * a * a) % 10};
        
        if (b % 4 != 0) return numbers[b % 4 - 1];
        return numbers[3];
    }
}