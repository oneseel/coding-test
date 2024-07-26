import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색을 하기 위해 정렬
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int sum = Integer.MAX_VALUE;

        int minLeft = 0;
        int minRight = 0;

        // 이분 탐색
        while (left < right) { // Changed from <= to <
            int temp = arr[left] + arr[right];

            if (Math.abs(temp) < Math.abs(sum)) {
                sum = temp;
                minLeft = left;
                minRight = right;
            }

            // 포인터 이동
            if (temp < 0) {
                left++;
            } else if (temp > 0) {
                right--;
            } else {
                // 합이 0인 경우 종료
                break;
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}
