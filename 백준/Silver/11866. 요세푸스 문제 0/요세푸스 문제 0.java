import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 오타 수정
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] answer = new int[n];
        int idx = 0;
        
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            count++;
            int current = queue.poll();
            if (count == k) {
                answer[idx++] = current;
                count = 0;
            } else {
                queue.offer(current);
            }
        }
        
        System.out.print("<");
        for (int i = 0; i < n; i++) {
            System.out.print(answer[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
