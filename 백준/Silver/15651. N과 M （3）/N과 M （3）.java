import java.io.*;
import java.util.*;

class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        
        bt(n, m, 0);
        
        System.out.println(sb);
        
    }
    
    private static void bt(int n, int m, int depth) {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            bt(n, m, depth + 1);
        }
    }
}