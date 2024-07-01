import java.io.*;
import java.util.*;

class Main {
    private static int[] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 점의 개수
        int m = Integer.parseInt(st.nextToken()); // 선분의 개수

        point = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            point[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point);

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 이분탐색
            int startIdx = binarySearch(start, 0);
            int endIdx = binarySearch(end, 1);

            System.out.println(endIdx - startIdx);
        }
    }

    private static int binarySearch(int start, int check) {
        int left = 0;
        int right = point.length - 1;

        if (check == 0){
            while (left <= right){
                int mid = (left + right) / 2;
                if (point[mid] < start) left = mid + 1;
                else right = mid - 1;
            }

            return left;
        }
        
        else {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (point[mid] > start) right = mid - 1;
                else left = mid + 1;
            }

            return right + 1;
        }
    }
}