import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리길이
        int l = Integer.parseInt(st.nextToken()); // 다리하중

        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0; // 총 걸린 시간
        int weight = 0; // 현재 다리하중
        int idx = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            queue.offer(0);
        }

        while (idx < n) {
            weight -= queue.poll();

            if (weight + truck[idx] <= l) {
                queue.offer(truck[idx]);
                weight += truck[idx];
                idx++;
            } else {
                queue.offer(0);
            }
            count++;
        }
        System.out.println(count + w);
    }
}
