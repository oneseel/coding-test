import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        // 각 월별 누적 일수
        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 요일 배열
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        // 입력받은 월까지의 총 일수를 계산
        for (int i = 1; i < month; i++) {
            day += daysOfMonth[i];
        }

        System.out.println(week[day % 7]);
    }
}
