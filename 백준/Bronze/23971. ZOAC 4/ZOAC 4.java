import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int height = count(H, N); // 세로줄에 앉을 수 있는 수
        int width = count(W, M); // 가로줄에 앉을 수 있는 수
        
        int result = height * width;
        
        System.out.println(result);

    }
    
    private static int count(int h, int n) {
        return (h + n) / (n + 1);
    }
}