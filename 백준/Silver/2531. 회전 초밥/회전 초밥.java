import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        // 입력된 초밥 번호를 저장
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 초밥 번호
        }

        // 연속성을 위해 배열을 2배로 늘림
        int[] sushi = new int[n * 2];
        for (int i = 0; i < n; i++) {
            sushi[i] = arr[i];
            sushi[i + n] = arr[i];
        }

        int max = 0;

        // 슬라이딩 윈도우 방식으로 k개 접시 검사
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            // 현재 윈도우에 있는 초밥 추가
            for (int j = 0; j < k; j++) {
                set.add(sushi[i + j]);
            }
            // 쿠폰 번호가 포함된 경우
            if (!set.contains(c)) {
                set.add(c); // 쿠폰 번호 추가
            }

            // 최대 초밥 종류 수 업데이트
            max = Math.max(max, set.size());
        }

        System.out.println(max);
    }
}
