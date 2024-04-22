import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 바구니의 개수
        int m = Integer.parseInt(st.nextToken()); // 바꿀 횟수
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            
            // 교환
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : list) {
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);
    }
}
