import java.io.*;
import java.util.*;

class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n];
        arr = new int[m];
        
        bt(n, m, 0, 1);
        
        System.out.println(sb);
    }
    
    private static void bt(int n, int m, int depth, int start) {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                arr[depth] = i;
                bt(n, m, depth + 1, i + 1);
                visited[i - 1] = false;
            }
        }
    }
}
