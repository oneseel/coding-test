import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = bfs(a, b);
        System.out.println(count);
    }

    private static int bfs(int start, int end) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[] {start, 1});

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long num = current[0];
            long count = current[1];

            if (num == end) return (int) count;

            long op1 = num * 2; // 2를 곱함
            String s = num + "1";
            long op2 = Long.parseLong(s); // 뒤에 1을 붙임

            if (op1 <= end) queue.offer(new long[] {op1, count + 1});
            if (op2 <= end) queue.offer(new long[] {op2, count + 1});
        }

        return -1;
    }
}
