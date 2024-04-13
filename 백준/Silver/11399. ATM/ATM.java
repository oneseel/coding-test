import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람 수
        int[] time = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken()); // 인출시간
        }
        
        // 오름차순으로 정렬
        Arrays.sort(time);
        
        int sum = 0;
        int total = 0;
        
        for (int i = 0; i < N; i++) {
            sum += time[i];
            total += sum;
        }
        System.out.println(total);
    }
}