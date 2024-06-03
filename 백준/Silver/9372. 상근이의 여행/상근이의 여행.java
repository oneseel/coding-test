import java.io.*;
import java.util.*;

class Main {
    private static boolean[] visited;
    private static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 국가
            int m = Integer.parseInt(st.nextToken()); // 비행기

            visited = new boolean[n + 1];
            list = new ArrayList<>();
            int count = 0;

            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }
            for (int i = 1; i < n + 1; i++) {
                 if (!visited[i]) {
                    count += bfs(i);
                }
            }
            System.out.println(count);
        }
    }

    private static int bfs (int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : list.get(current)) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}