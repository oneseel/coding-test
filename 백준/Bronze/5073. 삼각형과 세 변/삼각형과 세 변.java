import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] triangle = new int[3];
        int a = triangle[0];
        int b = triangle[1];
        int c = triangle[2];

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            Arrays.sort(triangle);

            // 삼각형 불가능할 때
            if (a + b <= c) sb.append("Invalid").append("\n");

                // Equilateral :  세 변의 길이가 모두 같은 경우
            else if (a == b && b == c) sb.append("Equilateral").append("\n");

                // Scalene : 세 변의 길이가 모두 다른 경우
            else if (a != b && b != c && c != a) sb.append("Scalene").append("\n");

                //  Isosceles : 두 변의 길이만 같은 경우
            else sb.append("Isosceles").append("\n");
            
        }

        System.out.println(sb);
    }
}