import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 무기의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // 돈
        int s = Integer.parseInt(st.nextToken()); // 공격력

        boolean isStart = false;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int attack = Integer.parseInt(st.nextToken());
            if (price <= x && attack > s) {
                isStart = true;
                break;
            }
        }

        if (isStart) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
