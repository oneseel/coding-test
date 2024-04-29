import java.io.*;
import java.util.*;

class Main {
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);
        long min = 0;
        long max = tree[N - 1];
        while (min <= max) {
            long mid = (min + max) / 2;
            if (cutTree(mid) >= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }

    private static long cutTree(long height) {
        long sum = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] > height) {
                sum += tree[i] - height;
            }
        }
        return sum;
    }
}
