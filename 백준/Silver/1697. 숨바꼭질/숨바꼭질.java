import java.io.*;
import java.util.*;

class Main {
    private static int n, k;
    private static int[] position = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        position[n] = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == k) {
                return position[current] - 1;
            }

            int[] nextPosition = {current - 1, current + 1, current * 2};

            for (int next : nextPosition) {
                if (0 <= next && next < position.length && position[next] == 0) {
                    queue.offer(next);
                    position[next] = position[current] + 1;
                }
            }
        }
        return -1;
    }
}